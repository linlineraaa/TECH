<template>
  <div>
    <el-form
        class="detail-form-content"
        ref="ruleForm"
        :model="ruleForm"
        :rules="rules"
        label-width="80px"
    >
      <div class="chat-content">
        <div v-bind:key="item.id" v-for="item in dataList">
          <div v-if="item.ask" class="left-content">
            <el-alert class="text-content" :title="item.ask" :closable="false" type="success"></el-alert>
          </div>
          <div v-else class="right-content">
            <el-alert class="text-content" :title="item.reply" :closable="false" type="warning"></el-alert>
          </div>
          <div class="clear-float"></div>
        </div>
      </div>
      <div class="clear-float"></div>
      <el-form-item label="reply" prop="reply">
        <el-input v-model="ruleForm.reply" placeholder="reply" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">reply</el-button>
        <el-button @click="back()">Back</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      id: "",
      ruleForm: {},
      dataList: [],
      rules: {
        reply: [
          {required: true, message: "replycontent cannot be empty", trigger: "blur"}
        ]
      },
      inter: null
    };
  },
  props: ["parent"],
  methods: {

    init(userid,askid) {
      this.id = userid;
      this.ruleForm.id=askid;
      var that = this;
      that.getList();
      var inter = setInterval(function () {
        that.getList();
      }, 3000)
      this.inter = inter;
    },

    getList() {
      let params = {
        sort: 'addtime',
        order: 'desc'
      }
      this.$http({
        url: this.$api.chatbyuseridpage + this.id,
        method: "get",
        params: params
      }).then(({data}) => {
        if (data && data.code === 0) {
          console.log(data);
          this.ruleForm.userid = this.id;
          this.dataList = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },

    onSubmit() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: this.$api.chatsave,
            method: "post",
            data: this.ruleForm
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: "Operationsuccess",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.getList();
                  this.ruleForm.reply = "";
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },

    back() {
      this.parent.showFlag = false;
      this.parent.getDataList();
      if (this.inter) {
        clearInterval(this.inter);
      }
    }
  }
};
</script>
<style lang="scss" scoped>
.chat-content {
  margin-left: 80px;
  padding-bottom: 60px;
  width: 500px;
  margin-bottom: 30px;
  max-height: 300px;
  height: 300px;
  overflow-y: scroll;
  border: 1px solid #eeeeee;

  .left-content {
    float: left;
    margin-bottom: 10px;
    padding: 10px;
  }

  .right-content {
    float: right;
    margin-bottom: 10px;
    padding: 10px;
  }
}

.clear-float {
  clear: both;
}
</style>
