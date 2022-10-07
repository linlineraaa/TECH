<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >
     <el-row>
                              <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="User Name"  prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" readonly              placeholder="User Name" clearable></el-input>
        </el-form-item>
      </el-col>
                                          <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="Name"  prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="Name" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="Age"  prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="Age" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="flag=='yonghu'"  label="Gender"   prop="xingbie">
          <el-select v-model="ruleForm.xingbie" placeholder="Gender">
            <el-option
                v-for="(item,index) in yonghuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="Mobile phone number"   prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="Mobile phone number" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="Email"  prop="youxiang">
          <el-input v-model="ruleForm.youxiang"               placeholder="Email" clearable></el-input>
        </el-form-item>
      </el-col>
                        <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="Student Number"   prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng"               placeholder="Student Number" clearable></el-input>
        </el-form-item>
      </el-col>
                                                                                                                                                      <el-form-item v-if="flag=='users'" label="User Name" prop="username">
        <el-input v-model="ruleForm.username"
        placeholder="User Name"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">Modify</el-button>
      </el-form-item>
      </el-col>
      </el-row>
    </el-form>
  </div>
</template>
<script>

import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
                                                                              yonghuxingbieOptions: [],
                                                                                                                                                                                        };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
                                                    this.yonghuxingbieOptions = "male,female,I don't want to say".split(',')
                                                                                                                          },
  methods: {
                                                                                                                                                                                                                                                                                                                                            onUpdateHandler() {
                              if((!this.ruleForm.yonghuming)&& 'yonghu'==this.flag){
        this.$message.error('User Name cannot be empty');
        return
      }
                                                                                                                                                                                                                                                                                                                  if( 'yonghu' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`Mobile phone number should be entered in mobile phone number format`);
        return
      }
                                                                        if( 'yonghu' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`Email should be entered in the Email format`);
        return
      }
                                                                        if( 'yonghu' ==this.flag && this.ruleForm.shenfenzheng&&(!checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`Academic number should be entered in the academic number format`);
        return
      }
                                                                                                                                                            this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "Modify information successfully",
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
  }
};
</script>
<style lang="scss" scoped>
</style>
