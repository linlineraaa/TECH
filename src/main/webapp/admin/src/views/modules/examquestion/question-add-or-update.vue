<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-form-item label="Select Exam" prop="paperid">
        <el-select @change="onPaperChange" v-model="ruleForm.paperid" placeholder="Select Exam">
          <el-option
            v-for="(item,index) in paperOptions"
            v-bind:key="index"
            :label="item.name"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Test" prop="questionname">
        <el-input
          style="width:600px;"
          type="textarea"
          min="1"
          v-model="ruleForm.questionname"
          placeholder="Test"
          clearable
        ></el-input>
      </el-form-item>
      <el-form-item label="Type" prop="type">
        <el-select @change="typeChange" v-model="ruleForm.type" placeholder="Type">
          <el-option label="Single-choice question" value="0"></el-option>
          <el-option label="Multiple Choice Questions" value="1"></el-option>
          <el-option label="Judgement Questions" value="2"></el-option>
          <el-option label="Fill-in-the-blank questions" value="3"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item v-if="ruleForm.type!=3&&ruleForm.type!=2" label="Options" prop="options">
        <div class="options" v-for="(item,index) in options" v-bind:key="index">
          {{item.text}}
          <el-button size="mini" @click="deleteOptions(index)" type="warning" round>Delete</el-button>
        </div>
        <el-button size="small" @click="addOptionsDialog" type="primary" round>Add option</el-button>
      </el-form-item>
      <el-form-item v-if="ruleForm.type==0 && options.length>0" label="Answers" prop="answer">
        <el-select v-model="ruleForm.answer">
          <el-option
            :label="item.code"
            :value="item.code"
            v-for="(item,index) in options"
            v-bind:key="index"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item v-if="ruleForm.type==1 && options.length>0" label="Answers" prop="answer">
        <el-select v-model="ruleForm.answer" multiple>
          <el-option
            :label="item.code"
            :value="item.code"
            v-for="(item,index) in options"
            v-bind:key="index"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item v-if="ruleForm.type==2 && options.length>0" label="Answers" prop="answer">
        <el-select v-model="ruleForm.answer">
          <el-option
            :label="item.text"
            :value="item.code"
            v-for="(item,index) in options"
            v-bind:key="index"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item v-if="ruleForm.type==3" label="Answers" prop="answer">
        <el-input v-model="ruleForm.answer" placeholder="Answers" clearAnswersable></el-input>
      </el-form-item>
      <el-form-item label="Score" prop="score">
        <el-input-number v-model="ruleForm.score" :min="1" :max="100" label="Score"></el-input-number>
      </el-form-item>
      <el-form-item label="Analysis" prop="analysis">
        <el-input
          style="width:600px;"
          type="textarea"
          min="1"
          v-model="ruleForm.analysis"
          placeholder="Analysis"
          clearable
        ></el-input>
      </el-form-item>
      <el-form-item label="Sort" prop="sequence">
        <el-input-number v-model="ruleForm.sequence" :min="1" :max="20" label="Sort"></el-input-number>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Submit</el-button>
        <el-button @click="back()">Cancel</el-button>
      </el-form-item>
    </el-form>
    <el-dialog title="Add option" :visible.sync="addOptionsDialogVisiable" width="50%">
      <el-form ref="dialogForm" :model="dialogForm" :rules="dialogRules" label-width="80px">
        <el-form-item label="Options" prop="code">
          <el-select v-model="dialogForm.code" placeholder="Options">
            <el-option label="A" value="A"></el-option>
            <el-option label="B" value="B"></el-option>
            <el-option label="C" value="C"></el-option>
            <el-option label="D" value="D"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Contents" prop="text">
          <el-input type="textarea" min="1" v-model="dialogForm.text" placeholder="content" clearable></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addOptionsDialogVisiable = false">Cancel</el-button>
        <el-button type="primary" @click="addOptions">Confirm</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import { isNumber } from "@/utils/validate";
export default {
  data() {
    var validateNumber = (rule, value, callback) => {
      if (!isNumber(value)) {
        callback(new Error("Please enter a number"));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {},
      options: [],
      addOptionsDialogVisiable: false,
      dialogForm: {},
      paperOptions: [],
      dialogRules: {
        text: [{ required: true, message: "Please fill in the content", trigger: "blur" }],
        code: [{ required: true, message: "Please select an option", trigger: "blur" }]
      },
      rules: {
        paperid: [{ required: true, message: "Please select an Quiz", trigger: "blur" }],
        questionname: [
          { required: true, message: "Test content cannot be empty", trigger: "blur" }
        ],
        type: [{ required: true, message: "Please select the type of test question", trigger: "blur" }],
        sequence: [{ required: true, message: "Sort cannot be empty", trigger: "blur" }],
        analysis: [
          { required: true, message: "Analysis cannot be empty", trigger: "blur" }
        ],
        score: [{ required: true, message: "Score cannot be empty", trigger: "blur" }]
      }
    };
  },
  props: ["parent"],
  methods: {

    init(id) {
      if (id) {
        this.info(id);
      } else {
        this.$http({
          url: this.$api.exampaperpage,
          method: "get",
          params: {
            page: 1,
            limit: 999
          }
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.paperOptions = data.data.list;
          }
        });
        this.ruleForm.created = new Date();
      }
    },
    info(id) {
      this.$http({
        url: this.$api.exampaperpage,
        method: "get",
        params: {
          page: 1,
          limit: 999
        }
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.paperOptions = data.data.list;
          this.$http({
            url: `${this.$api.examquestioninfo}${id}`,
            method: "get"
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.ruleForm = data.data;
              this.ruleForm.type = this.ruleForm.type + "";
              this.options = JSON.parse(this.ruleForm.options);
              if (this.ruleForm.type == 1) {
                this.ruleForm.answer = this.ruleForm.answer.split(",");
              }
              console.log(this.options);
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },

    onSubmit() {
      console.log(this.ruleForm.answer);

      if (!this.options && this.type != 3) {
        this.$message.error("Please set options");
        return;
      }
      if (this.ruleForm.type == 1) {
        this.ruleForm.answer = this.ruleForm.answer.join(",");
        console.log(this.ruleForm.answer);
      }
      this.ruleForm.options = JSON.stringify(this.options);
      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `${
              !this.ruleForm.id
                ? `${this.$api.examquestionsave}`
                : `${this.$api.examquestionupdate}`
            }`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "Successful operation",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = false;
                  this.parent.search();
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
    },
    addOptionsDialog() {
      this.addOptionsDialogVisiable = !this.addOptionsDialogVisiable;
    },
    addOptions() {
      this.$refs["dialogForm"].validate(valid => {
        if (valid) {
          this.options.push({
            text: this.dialogForm.code + "." + this.dialogForm.text,
            code: this.dialogForm.code
          });
          this.dialogForm = {};
          this.addOptionsDialogVisiable = !this.addOptionsDialogVisiable;
        }
      });
    },
    deleteOptions(index) {
      console.log(index);
      this.options.splice(index, 1);
    },
    onPaperChange(e) {
      console.log(e);
      for (let item of this.paperOptions) {
        if (item.id == e) {

          this.ruleForm.papername = item.name;
        }
      }
    },
    typeChange(e) {
      console.log(e);
      if (e == 2) {
        this.options = [];
        this.options.push({
          text: "A.correct",
          code: "A"
        });
        this.options.push({
          text: "B.wrong",
          code: "B"
        });
      } else {
        this.options = [];
      }
    }
  }
};
</script>
<style lang="scss" scoped>
.editor {
  height: 500px;
}
.options {
  margin-bottom: 10px;
  display: flex;
  justify-content: space-between;
  width: 200px;
}
</style>
