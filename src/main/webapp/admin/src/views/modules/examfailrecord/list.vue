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
          <el-table-column prop="userid" header-align="center" align="center" sortable label="User ID"></el-table-column>
          <el-table-column
            prop="papername"
            header-align="center"
            align="center"
            sortable
            label="Quiz"
          ></el-table-column>
          <el-table-column
            prop="questionname"
            header-align="center"
            align="center"
            sortable
            label="Questions Name"
          ></el-table-column>
          <el-table-column prop="score" header-align="center" align="center" sortable label="Score"></el-table-column>
          <el-table-column prop="answer" header-align="center" align="center" sortable label="Correct answer"></el-table-column>
          <el-table-column
            prop="myanswer"
            header-align="center"
            align="center"
            sortable
            label="Student answers"
          ></el-table-column>
          <el-table-column
            prop="analysis"
            header-align="center"
            align="center"
            sortable
            label="Analysis of Questions"
          ></el-table-column>
          <el-table-column
            prop="addtime"
            header-align="center"
            align="center"
            sortable
            width="170"
            label="Quiz Time"
          ></el-table-column>
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
  </div>
</template>
<script>
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
      showFlag: false,
      user: {}
    };
  },
  mounted() {
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.user = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.init();
    this.getDataList();
  },
  components: {},
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
        sort: "id",
        myscore: 0,
        userid: this.id
      };
      if (this.searchForm.papername) {
        params["papername"] = `%${this.searchForm.papername}%`;
      }
      if (this.searchForm.questionname) {
        params["questionname"] = `%${this.searchForm.questionname}%`;
      }
      this.$http({
        url: this.$api.examrecordpage,
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
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
