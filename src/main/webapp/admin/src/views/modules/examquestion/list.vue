<template>
  <div class="main-content">

    <div v-if="!showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-form-item label="Quiz">
          <el-input v-model="searchForm.papername" placeholder="Quiz Name" clearable></el-input>
        </el-form-item>
        <el-form-item label="Questions">
          <el-input v-model="searchForm.questionname" placeholder="Questions Name" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button round @click="search()">Search</el-button>
          <el-button type="primary" @click="addOrUpdateHandler()" round>New</el-button>
          <el-button
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >Delete</el-button>
        </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
          :data="dataList"
          border
          v-loading="dataListLoading"
          @selection-change="selectionChangeHandler"
          style="width: 100%;"
        >
          <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
          <el-table-column
            width="300"
            prop="papername"
            header-align="center"
            align="center"
            sortable
            label="Quiz"
          ></el-table-column>
          <el-table-column
            width="300"
            prop="questionname"
            header-align="center"
            align="center"
            sortable
            label="Questions Name"
          ></el-table-column>
          <el-table-column prop="score" header-align="center" align="center" sortable label="Value"></el-table-column>
          <el-table-column prop="answer" header-align="center" align="center" sortable label="Answer"></el-table-column>
          <el-table-column prop="type" header-align="center" align="center" sortable label="Type">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.type==0">Single-choice question</el-tag>
              <el-tag v-if="scope.row.type==1" type="info">Multiple Choice Questions</el-tag>
              <el-tag v-if="scope.row.type==2" type="success">Judgement Questions</el-tag>
              <el-tag v-if="scope.row.type==3" type="warning">Fill-in-the-blank questions</el-tag>
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
                @click="addOrUpdateHandler(scope.row.id)"
              >Modify</el-button>
              <el-button
                type="text"
                icon="el-icon-delete"
                size="small"
                @click="deleteHandler(scope.row.id)"
              >Delete</el-button>
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
import AddOrUpdate from "./question-add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: false
    };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  components: {
    AddOrUpdate
  },
  methods: {
    init() {},
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    getDataList() {
      this.dataListLoading = true;
      var params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: "id"
      };
      if(this.searchForm.papername){
        params['papername'] = `%${this.searchForm.papername}%`
      }
      if(this.searchForm.questionname){
        params['questionname'] = `%${this.searchForm.questionname}%`
      }
      this.$http({
        url: this.$api.examquestionpage,
        method: "get",
        params: params
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

    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },

    addOrUpdateHandler(id) {
      this.showFlag = true;
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id);
      });
    },

    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`Determine to proceed[${id ? "Delete" : "Bulk Delete"}]Operation?`, "Tips", {
        confirmButtonText: "Confirm",
        cancelButtonText: "Cancel",
        type: "warning"
      }).then(() => {
        this.$http({
          url: this.$api.examquestiondelete,
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "Successful operation",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
