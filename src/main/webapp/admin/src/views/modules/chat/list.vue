<template>
  <div class="main-content">

    <div v-if="!showFlag">
      <div class="table-content">
        <el-table
          :data="dataList"
          border
          v-loading="dataListLoading"
          style="width: 100%;"
        >
          <el-table-column prop="ask" header-align="center" align="center" sortable label="New information"></el-table-column>
          <el-table-column
            prop="allnode"
            header-align="center"
            align="center"
            sortable
            label="Status"
            width="150"
          >
            <template slot-scope="scope">
              <el-tag v-if="scope.row.isreply==1" type="success">No reply</el-tag>
              <el-tag v-if="scope.row.isreply==0" type="info">Replied</el-tag>
            </template>
          </el-table-column>
          <el-table-column
            fixed="right"
            header-align="center"
            align="center"
            width="150"
            label="Operation"
          >
            <template slot-scope="scope">
              <el-button
                type="text"
                icon="el-icon-edit"
                size="small"
                @click="addOrUpdateHandler(scope.row)"
              >Reply</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>

    <add-or-update v-else :parent="this" ref="addOrUpdate"></add-or-update>
  </div>
</template>
<script>
import AddOrUpdate from "./chat-add-or-update";
import { setInterval, clearInterval } from 'timers';
export default {
  data() {
    return {
      searchForm: {},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      showFlag: false,
      dataListSelections: [],
      inter: null
    };
  },
  created() {
    var that = this;
    that.getDataList();
    var inter = setInterval(function(){
        that.getDataList();
    },5000);
    this.inter = inter;
  },
  destroyed(){
    clearInterval(this.inter);
  },
  components: {
    AddOrUpdate
  },
  methods: {
    getDataList() {
      this.dataListLoading = true;
      this.$http({
        url: this.$api.chatpage,
        method: "get",
        params: {
          page: this.pageIndex,
          limit: this.pageSize,
          sort: 'id',
          adminid: '',
        }
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },

    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },

    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },

    addOrUpdateHandler(row) {
      this.showFlag = true;
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(row.userid,row.id);
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
