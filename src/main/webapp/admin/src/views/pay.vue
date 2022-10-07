<template>
  <div class="container">
    <el-alert title="please check order before pay" type="success" :closable="false"></el-alert>
    <div class="pay-type-content">
      <div class="pay-type-item">
        <el-radio v-model="type" label="wechat pay"></el-radio>
        <img src="@/assets/img/test/weixin.png" alt>
        <!-- <span>wechat pay</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="alipay"></el-radio>
        <img src="@/assets/img/test/zhifubao.png" alt>
        <!-- <span>alipay</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="constructionbank"></el-radio>
        <img src="@/assets/img/test/jianshe.png" alt>
        <!-- <span>constructionbank</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="agriculture bank"></el-radio>
        <img src="@/assets/img/test/nongye.png" alt>
        <!-- <span>agriculture bank</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="china bank"></el-radio>
        <img src="@/assets/img/test/zhongguo.png" alt>
        <!-- <span>china bank</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="communications bank"></el-radio>
        <img src="@/assets/img/test/jiaotong.png" alt>
        <!-- <span>communications bank</span> -->
      </div>
    </div>
    <div class="buton-content">
      <el-button @click="submitTap" type="primary">confirm pay</el-button>
      <el-button @click="back()">Back</el-button>
    </div>
  </div>
</template>
<script>

export default {
  data() {
    return {
      name: "",
      account: "",
      type: "",
      table: "",
      obj: ""
    };
  },
  mounted() {
    let table = this.$storage.get("paytable");
    let obj = this.$storage.getObj("payObject");
    this.table = table;
    this.obj = obj;
  },
  methods: {
    submitTap() {








      if (!this.type) {
        this.$message.error("SelectPayWay");
        return;
      }
      this.$confirm(`ConfirmPay?`, "Tips", {
        confirmButtonText: "Confirm",
        cancelButtonText: "Cancel",
        type: "warning"
      }).then(() => {
        this.obj.ispay = "AlreadyPay";
        this.$http({
          url: `${this.table}/update`,
          method: "post",
          data: this.obj
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "Paysuccess",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.$router.go(-1);
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    back(){
      this.$router.go(-1);
    }
  }
};
</script>
<style lang="scss" scoped>
.container {
  margin: 10px;
  font-size: 14px;
  span {
    width: 60px;
  }
  .top-content {
    display: flex;
    align-items: center;
    padding: 20px;
  }
  .price-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    padding-bottom: 20px;
    padding: 20px;
    border-bottom: 1px solid #eeeeee;
    font-size: 20px;
    font-weight: bold;
    color: red;
  }
  .pay-type-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    flex-wrap: wrap;
    span {
      width: 100px;
    }
    .pay-type-item {
      display: flex;
      align-items: center;
      justify-content: space-between;
      width: 300px;
      margin: 20px;
      border: 1px solid #eeeeee;
      padding: 20px;
    }
  }
  .buton-content {
    margin: 20px;
  }
}
</style>
