<template>
  <div class="addEdit-block">
    <el-form
        class="detail-form-content"
        ref="ruleForm"
        :model="ruleForm"
        :rules="rules"
        label-width="80px"
        :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
        <el-col :span="12">
          <el-form-item class="input" v-if="type!='info'" label="Collection id" prop="refid">
            <el-input v-model="ruleForm.refid"
                      placeholder="Collection id" clearable :readonly="ro.refid"></el-input>
          </el-form-item>
          <div v-else>
            <el-form-item class="input" label="Collection id" prop="refid">
              <el-input v-model="ruleForm.refid"
                        placeholder="Collection id" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="12">
          <el-form-item class="input" v-if="type!='info'" label="Collectionname" prop="name">
            <el-input v-model="ruleForm.name"
                      placeholder="Collectionname" clearable :readonly="ro.name"></el-input>
          </el-form-item>
          <div v-else>
            <el-form-item class="input" label="Collectionname" prop="name">
              <el-input v-model="ruleForm.name"
                        placeholder="Collectionname" readonly></el-input>
            </el-form-item>
          </div>
        </el-col>
        <el-col :span="24">
          <el-form-item class="upload" v-if="type!='info' && !ro.picture" label="Collectionpicture " prop="picture">
            <file-upload
                tip="click to uploadCollectionpicture "
                action="file/upload"
                :limit="3"
                :multiple="true"
                :fileUrls="ruleForm.picture?ruleForm.picture:''"
                @change="pictureUploadChange"
            ></file-upload>
          </el-form-item>
          <div v-else>
            <el-form-item v-if="ruleForm.picture" label="Collectionpicture " prop="picture">
              <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.picture.split(',')"
                   :src="item" width="100" height="100">
            </el-form-item>
          </div>
        </el-col>
      </el-row>
      <el-form-item class="btn">
        <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">Submit</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">Cancel</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">Back</el-button>
      </el-form-item>
    </el-form>


  </div>
</template>
<script>

import {isNumber, isIntNumer, isEmail, isPhone, isMobile, isURL, checkIdCard} from "@/utils/validate";

export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("please input correct student number"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isURL(value)) {
        callback(new Error("please input correct URL"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("please input correct phone"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("please input correct phone"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("please input correct email"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("please input number"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if (!value) {
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("please input integer"));
      } else {
        callback();
      }
    };
    return {
      addEditForm: {
        "btnSaveFontColor": "#fff",
        "selectFontSize": "14px",
        "btnCancelBorderColor": "#DCDFE6",
        "inputBorderRadius": "4px",
        "inputFontSize": "14px",
        "textareaBgColor": "#fff",
        "btnSaveFontSize": "14px",
        "textareaBorderRadius": "4px",
        "uploadBgColor": "#fff",
        "textareaBorderStyle": "solid",
        "btnCancelWidth": "88px",
        "textareaHeight": "120px",
        "dateBgColor": "#fff",
        "btnSaveBorderRadius": "4px",
        "uploadLableFontSize": "14px",
        "textareaBorderWidth": "1px",
        "inputLableColor": "#606266",
        "addEditBoxColor": "rgba(255, 255, 255, 1)",
        "dateIconFontSize": "14px",
        "btnSaveBgColor": "#409EFF",
        "uploadIconFontColor": "#8c939d",
        "textareaBorderColor": "#DCDFE6",
        "btnCancelBgColor": "#ecf5ff",
        "selectLableColor": "#606266",
        "btnSaveBorderStyle": "solid",
        "dateBorderWidth": "1px",
        "dateLableFontSize": "14px",
        "dateBorderRadius": "4px",
        "btnCancelBorderStyle": "solid",
        "selectLableFontSize": "14px",
        "selectBorderStyle": "solid",
        "selectIconFontColor": "#C0C4CC",
        "btnCancelHeight": "44px",
        "inputHeight": "40px",
        "btnCancelFontColor": "#606266",
        "dateBorderColor": "#DCDFE6",
        "dateIconFontColor": "#C0C4CC",
        "uploadBorderStyle": "solid",
        "dateBorderStyle": "solid",
        "dateLableColor": "#606266",
        "dateFontSize": "14px",
        "inputBorderWidth": "1px",
        "uploadIconFontSize": "28px",
        "selectHeight": "40px",
        "inputFontColor": "#606266",
        "uploadHeight": "148px",
        "textareaLableColor": "#606266",
        "textareaLableFontSize": "14px",
        "btnCancelFontSize": "14px",
        "inputBorderStyle": "solid",
        "btnCancelBorderRadius": "4px",
        "inputBgColor": "#fff",
        "inputLableFontSize": "14px",
        "uploadLableColor": "#606266",
        "uploadBorderRadius": "4px",
        "btnSaveHeight": "44px",
        "selectBgColor": "#fff",
        "btnSaveWidth": "88px",
        "selectIconFontSize": "14px",
        "dateHeight": "40px",
        "selectBorderColor": "#DCDFE6",
        "inputBorderColor": "#DCDFE6",
        "uploadBorderColor": "#DCDFE6",
        "textareaFontColor": "#606266",
        "selectBorderWidth": "1px",
        "dateFontColor": "#606266",
        "btnCancelBorderWidth": "1px",
        "uploadBorderWidth": "1px",
        "textareaFontSize": "14px",
        "selectBorderRadius": "4px",
        "selectFontColor": "#606266",
        "btnSaveBorderColor": "#409EFF",
        "btnSaveBorderWidth": "1px"
      },
      id: '',
      type: '',
      ro: {
        userid: false,
        refid: false,
        tablename: false,
        name: false,
        picture: false,
      },
      ruleForm: {
        userid: '',
        refid: '',
        tablename: '',
        name: '',
        picture: '',
      },
      rules: {
        userid: [
          {required: true, message: 'Userid cannot be empty', trigger: 'blur'},
        ],
        refid: [],
        tablename: [],
        name: [
          {required: true, message: 'Collectionname cannot be empty', trigger: 'blur'},
        ],
        picture: [
          {required: true, message: 'Collectionpicture  cannot be empty', trigger: 'blur'},
        ],
      }
    };
  },
  props: ["parent"],
  computed: {},
  created() {
    this.addEditStyleChange()
    this.addEditUploadStyleChange()
  },
  methods: {

    download(file) {
      window.open(`${file}`)
    },

    init(id, type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if (this.type == 'info' || this.type == 'else') {
        this.info(id);
      } else if (this.type == 'cross') {
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj) {
          if (o == 'userid') {
            this.ruleForm.userid = obj[o];
            this.ro.userid = true;
            continue;
          }
          if (o == 'refid') {
            this.ruleForm.refid = obj[o];
            this.ro.refid = true;
            continue;
          }
          if (o == 'tablename') {
            this.ruleForm.tablename = obj[o];
            this.ro.tablename = true;
            continue;
          }
          if (o == 'name') {
            this.ruleForm.name = obj[o];
            this.ro.name = true;
            continue;
          }
          if (o == 'picture') {
            this.ruleForm.picture = obj[o];
            this.ro.picture = true;
            continue;
          }
        }
      }
    },

    info(id) {
      this.$http({
        url: `storeup/info/${id}`,
        method: "get"
      }).then(({data}) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },

    onSubmit() {


      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `storeup/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: "Operationsuccess",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.storeupCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },

    getUUID() {
      return new Date().getTime();
    },

    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.storeupCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    pictureUploadChange(fileUrls) {
      this.ruleForm.picture = fileUrls;
      this.addEditUploadStyleChange()
    },
    addEditStyleChange() {
      this.$nextTick(() => {

        document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.inputHeight
          el.style.color = this.addEditForm.inputFontColor
          el.style.fontSize = this.addEditForm.inputFontSize
          el.style.borderWidth = this.addEditForm.inputBorderWidth
          el.style.borderStyle = this.addEditForm.inputBorderStyle
          el.style.borderColor = this.addEditForm.inputBorderColor
          el.style.borderRadius = this.addEditForm.inputBorderRadius
          el.style.backgroundColor = this.addEditForm.inputBgColor
        })
        document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.inputHeight
          el.style.color = this.addEditForm.inputLableColor
          el.style.fontSize = this.addEditForm.inputLableFontSize
        })

        document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.selectHeight
          el.style.color = this.addEditForm.selectFontColor
          el.style.fontSize = this.addEditForm.selectFontSize
          el.style.borderWidth = this.addEditForm.selectBorderWidth
          el.style.borderStyle = this.addEditForm.selectBorderStyle
          el.style.borderColor = this.addEditForm.selectBorderColor
          el.style.borderRadius = this.addEditForm.selectBorderRadius
          el.style.backgroundColor = this.addEditForm.selectBgColor
        })
        document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.selectHeight
          el.style.color = this.addEditForm.selectLableColor
          el.style.fontSize = this.addEditForm.selectLableFontSize
        })
        document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el => {
          el.style.color = this.addEditForm.selectIconFontColor
          el.style.fontSize = this.addEditForm.selectIconFontSize
        })

        document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el => {
          el.style.height = this.addEditForm.dateHeight
          el.style.color = this.addEditForm.dateFontColor
          el.style.fontSize = this.addEditForm.dateFontSize
          el.style.borderWidth = this.addEditForm.dateBorderWidth
          el.style.borderStyle = this.addEditForm.dateBorderStyle
          el.style.borderColor = this.addEditForm.dateBorderColor
          el.style.borderRadius = this.addEditForm.dateBorderRadius
          el.style.backgroundColor = this.addEditForm.dateBgColor
        })
        document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.dateHeight
          el.style.color = this.addEditForm.dateLableColor
          el.style.fontSize = this.addEditForm.dateLableFontSize
        })
        document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el => {
          el.style.color = this.addEditForm.dateIconFontColor
          el.style.fontSize = this.addEditForm.dateIconFontSize
          el.style.lineHeight = this.addEditForm.dateHeight
        })

        let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
        document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el => {
          el.style.width = this.addEditForm.uploadHeight
          el.style.height = this.addEditForm.uploadHeight
          el.style.borderWidth = this.addEditForm.uploadBorderWidth
          el.style.borderStyle = this.addEditForm.uploadBorderStyle
          el.style.borderColor = this.addEditForm.uploadBorderColor
          el.style.borderRadius = this.addEditForm.uploadBorderRadius
          el.style.backgroundColor = this.addEditForm.uploadBgColor
        })
        document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el => {
          el.style.lineHeight = this.addEditForm.uploadHeight
          el.style.color = this.addEditForm.uploadLableColor
          el.style.fontSize = this.addEditForm.uploadLableFontSize
        })
        document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el => {
          el.style.color = this.addEditForm.uploadIconFontColor
          el.style.fontSize = this.addEditForm.uploadIconFontSize
          el.style.lineHeight = iconLineHeight
          el.style.display = 'block'
        })

        document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el => {
          el.style.height = this.addEditForm.textareaHeight
          el.style.color = this.addEditForm.textareaFontColor
          el.style.fontSize = this.addEditForm.textareaFontSize
          el.style.borderWidth = this.addEditForm.textareaBorderWidth
          el.style.borderStyle = this.addEditForm.textareaBorderStyle
          el.style.borderColor = this.addEditForm.textareaBorderColor
          el.style.borderRadius = this.addEditForm.textareaBorderRadius
          el.style.backgroundColor = this.addEditForm.textareaBgColor
        })
        document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el => {

          el.style.color = this.addEditForm.textareaLableColor
          el.style.fontSize = this.addEditForm.textareaLableFontSize
        })

        document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el => {
          el.style.width = this.addEditForm.btnSaveWidth
          el.style.height = this.addEditForm.btnSaveHeight
          el.style.color = this.addEditForm.btnSaveFontColor
          el.style.fontSize = this.addEditForm.btnSaveFontSize
          el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
          el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
          el.style.borderColor = this.addEditForm.btnSaveBorderColor
          el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
          el.style.backgroundColor = this.addEditForm.btnSaveBgColor
        })

        document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el => {
          el.style.width = this.addEditForm.btnCancelWidth
          el.style.height = this.addEditForm.btnCancelHeight
          el.style.color = this.addEditForm.btnCancelFontColor
          el.style.fontSize = this.addEditForm.btnCancelFontSize
          el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
          el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
          el.style.borderColor = this.addEditForm.btnCancelBorderColor
          el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
          el.style.backgroundColor = this.addEditForm.btnCancelBgColor
        })
      })
    },
    addEditUploadStyleChange() {
      this.$nextTick(() => {
        document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el => {
          el.style.width = this.addEditForm.uploadHeight
          el.style.height = this.addEditForm.uploadHeight
          el.style.borderWidth = this.addEditForm.uploadBorderWidth
          el.style.borderStyle = this.addEditForm.uploadBorderStyle
          el.style.borderColor = this.addEditForm.uploadBorderColor
          el.style.borderRadius = this.addEditForm.uploadBorderRadius
          el.style.backgroundColor = this.addEditForm.uploadBgColor
        })
      })
    },
  }
};
</script>
<style lang="scss">
.editor {
  height: 500px;

  & /deep/ .ql-container {
    height: 310px;
  }
}

.amap-wrapper {
  width: 100%;
  height: 500px;
}

.search-box {
  position: absolute;
}

.addEdit-block {
  margin: -10px;
}

.detail-form-content {
  padding: 12px;
}

.btn .el-button {
  padding: 0;
}
</style>
