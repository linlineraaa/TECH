<template>
  <div>
    <div class="container">
      <div class="login-form" style="backgroundColor:rgba(255, 255, 255, 0.22);borderRadius:10px">
        <h1 class="h1" style="color:rgba(104, 223, 240, 1);fontSize:28px;">Teach Programming Website Registration</h1>
		<el-form ref="rgsForm" class="rgs-form" :model="rgsForm" label-width="120px">
															<!-- <div v-if="tableName=='yonghu'" class="input-group">
			   <div class="label">username</div>
			   <div class="input-container">
			     <input v-model="ruleForm.yonghuming" class="input" type="text" placeholder="User Name">
			   </div>
			 </div> -->
			<el-form-item label="User Name" class="input" v-if="tableName=='yonghu'">
			  <el-input v-model="ruleForm.yonghuming" autocomplete="off" placeholder="User Name" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='yonghu'" class="input-group">
			   <div class="label">Password</div>
			   <div class="input-container">
			     <input v-model="ruleForm.mima" class="input" type="text" placeholder="Password">
			   </div>
			 </div> -->
			<el-form-item label="Password" class="input" v-if="tableName=='yonghu'">
			  <el-input v-model="ruleForm.mima" autocomplete="off" placeholder="Password" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='yonghu'" class="input-group">
			   <div class="label">Name</div>
			   <div class="input-container">
			     <input v-model="ruleForm.xingming" class="input" type="text" placeholder="Name">
			   </div>
			 </div> -->
			<el-form-item label="Name" class="input" v-if="tableName=='yonghu'">
			  <el-input v-model="ruleForm.xingming" autocomplete="off" placeholder="Name" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='yonghu'" class="input-group">
			   <div class="label">Age</div>
			   <div class="input-container">
			     <input v-model="ruleForm.nianling" class="input" type="text" placeholder="Age">
			   </div>
			 </div> -->
			<el-form-item label="Age" class="input" v-if="tableName=='yonghu'">
			  <el-input v-model="ruleForm.nianling" autocomplete="off" placeholder="Age" type="text" />
			</el-form-item>
																					<!-- <div v-if="tableName=='yonghu'" class="input-group">
			   <div class="label">Phone Number</div>
			   <div class="input-container">
			     <input v-model="ruleForm.shouji" class="input" type="text" placeholder="Phone Number">
			   </div>
			 </div> -->
			<el-form-item label="Phone Number" class="input" v-if="tableName=='yonghu'">
			  <el-input v-model="ruleForm.shouji" autocomplete="off" placeholder="Phone Number" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='yonghu'" class="input-group">
			   <div class="label">Email</div>
			   <div class="input-container">
			     <input v-model="ruleForm.youxiang" class="input" type="text" placeholder="Email">
			   </div>
			 </div> -->
			<el-form-item label="Email" class="input" v-if="tableName=='yonghu'">
			  <el-input v-model="ruleForm.youxiang" autocomplete="off" placeholder="Email" type="text" />
			</el-form-item>
												<!-- <div v-if="tableName=='yonghu'" class="input-group">
			   <div class="label">Student Number</div>
			   <div class="input-container">
			     <input v-model="ruleForm.shenfenzheng" class="input" type="text" placeholder="Student Number">
			   </div>
			 </div> -->
			<el-form-item label="Student Number" class="input" v-if="tableName=='yonghu'">
			  <el-input v-model="ruleForm.shenfenzheng" autocomplete="off" placeholder="Student Number" type="text" />
			</el-form-item>
																																																																											<el-button class="btn" type="primary" @click="login()">Registration</el-button>
		</el-form>
      </div>
      <!-- <div class="nk-navigation">
        <a href="#">
          <div @click="login()">Registration</div>
        </a>
      </div> -->
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
              },
      tableName:"",
      rules: {}
    };
  },
  mounted(){
    let table = this.$storage.get("loginTable");
    this.tableName = table;
  },
  methods: {

    getUUID () {
      return new Date().getTime();
    },

    login() {
                              if((!this.ruleForm.yonghuming) && `yonghu` == this.tableName){
        this.$message.error(`username cannot be empty`);
        return
      }
                                                                                                                                                                                                                                                                                                                  if(`yonghu` == this.tableName && this.ruleForm.shouji&&(!this.$validate.isMobile(this.ruleForm.shouji))){
        this.$message.error(`Mobile phones should be entered in mobile phone format`);
        return
      }
                                                                        if(`yonghu` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
        this.$message.error(`Mailboxes should be entered in the email format`);
        return
      }
                                                                        if(`yonghu` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`The student number should be entered in school number format`);
        return
      }
                                                                                                                                                            this.$http({
        url: `${this.tableName}/register`,
        method: "post",
        data:this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "Registration successful",
            type: "success",
            duration: 1500,
            onClose: () => {
              this.$router.replace({ path: "/login" });
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.h1 {
		margin-top: 10px;
	}

	body {
		padding: 0;
		margin: 0;
	}











































































	.nk-navigation {
		margin-top: 15px;

		a {
			display: inline-block;
			color: #fff;
			background: rgba(255, 255, 255, .2);
			width: 100px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;
		}

		.icon {
			margin-left: 10px;
			width: 30px;
			height: 30px;
		}
	}

	.register-container {
		margin-top: 10px;

		a {
			display: inline-block;
			color: #fff;
			max-width: 500px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;

			div {
				margin-left: 10px;
			}
		}
	}

	.container {
		background-image: url("http://codegen.caihongy.cn/20201206/386e55b97f7b4b4a8ecc5fd3c6df11e3.jpg");
		height: 100vh;
		background-position: center center;
		background-size: cover;
		background-repeat: no-repeat;

		.login-form {
			right: 50%;
			top: 50%;
			height: auto;
			transform: translate3d(50%, -50%, 0);
			border-radius: 10px;
			background-color: rgba(255,255,255,.5);
			width: 420px;
			padding: 30px 30px 40px 30px;
			font-size: 14px;
			font-weight: 500;

			.h1 {
				margin: 0;
				text-align: center;
				line-height: 54px;
			    font-size: 24px;
			    color: #000;
			}

			.rgs-form {
				display: flex;
				flex-direction: column;
				justify-content: center;
				align-items: center;

				.input {
					width: 100%;

					& /deep/ .el-form-item__label {
						line-height: 40px;
						color: rgba(104, 223, 240, 1);
						font-size: #606266;
					}

					& /deep/ .el-input__inner {
						height: 40px;
						color: #606266;
						font-size: 14px;
						border-width: 1px;
						border-style: solid;
						border-color: #606266;
						border-radius: 4px;
						background-color: #fff;
					}
				}

				.btn {
					width: 88px;
					height: 44px;
					color: #fff;
					font-size: 14px;
					border-width: 0px;
					border-style: solid;
					border-color: #409EFF;
					border-radius: 4px;
					background-color: rgba(104, 223, 240, 1);
				}
			}
		}
	}
</style>
