<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :rules="rules"
      :model="ruleForm"
      label-width="auto"
    >
      <el-form-item label="Original Password" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item label="New password" prop="newpassword">
        <el-input v-model="ruleForm.newpassword"></el-input>
      </el-form-item>
      <el-form-item label="Confirm Password" prop="repassword">
        <el-input v-model="ruleForm.repassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">Confirm</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      dialogVisible: false,
      ruleForm: {},
      user: {},
      rules: {
        password: [
          {
            required: true,
            message: "Password  cannot be empty",
            trigger: "blur"
          }
        ],
        newpassword: [
          {
            required: true,
            message: "New password cannot be empty",
            trigger: "blur"
          }
        ],
        repassword: [
          {
            required: true,
            message: "Confirm Password cannot be empty",
            trigger: "blur"
          }
        ]
      }
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
  },
  methods: {
    onLogout() {
      this.$storage.remove("Token");
      this.$router.replace({ name: "login" });
    },

    onUpdateHandler() {
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          var password = "";
          if (this.user.mima) {
            password = this.user.mima;
          } else if (this.user.password) {
            password = this.user.password;
          }
          if (this.ruleForm.password != password) {
            this.$message.error("Original Password Wrong");
            return;
          }
          if (this.ruleForm.newpassword != this.ruleForm.repassword) {
            this.$message.error("Two inconsistent password entries");
            return;
          }
          this.user.password = this.ruleForm.newpassword;
          this.user.mima = this.ruleForm.newpassword;
          this.$http({
            url: `${this.$storage.get("sessionTable")}/update`,
            method: "post",
            data: this.user
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "Change password Successful,Effective next time you log in to the system",
                type: "success",
                duration: 1500,
                onClose: () => {
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
