<template>
  <div class="main-content">

    <div v-if="!showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
        <el-form-item label="Quiz">
          <el-input v-model="searchForm.name" placeholder="Quiz Name" clearable></el-input>
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
          <el-table-column prop="name" header-align="center" align="center" sortable label="Quiz"></el-table-column>
          <el-table-column
            prop="time"
            header-align="center"
            align="center"
            sortable
            label="Length of Quiz/minute"
          >
            <template slot-scope="scope">{{scope.row.time}}</template>
          </el-table-column>
          <!-- <el-table-column prop="status" header-align="center" align="center" sortable label="Quiz Status">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.status==1" type="info">Enable</el-tag>
              <el-tag v-if="scope.row.status==0" type="warning">Prohibited</el-tag>
            </template>
          </el-table-column>-->
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
              >Quiz</el-button>
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
        status: "1"
      };
      if (this.searchForm.name) {
        params["name"] = `%${this.searchForm.name}%`;
      }
      this.$http({
        url: this.$api.exampaperpage,
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
      localStorage.setItem("userTable", this.$storage.get("sessionTable"));
      window.location.href = `http://localhost:8080/teach/front/pages/exampaper/exam.html?id=${id}`
      // this.$http({
      //   url: `examrecord/deleteRecords?userid=${this.user.id}&paperid=${id}`,
      //   method: "post",
      //   data: {}
      // }).then(({ data }) => {});
      // this.$router.push({
      //   name: "adminexam",
      //   params: {
      //     id: id
      //   }
      // });
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
          url: this.$api.exampaperdelete,
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
