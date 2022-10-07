<template>
  <div class="container">
    <div class="top-content">
      <div class="left-content">
        current no.
        <span class="tip-text">{{currentIndex+1}}</span> 。Unanswered questions：
        <span class="tip-text">{{dataList.length - currentIndex-1}}</span>，General title：
        <span class="tip-text">{{dataList.length}}</span>.
      </div>
      <div class="right-content">
        Time remaining in the Quiz：
        <span class="tip-text">{{SecondToDate}}</span>
      </div>
      <div class="right-content">
        <el-button type="danger" round @click="leaveTap">End of examination</el-button>
      </div>
    </div>
    <div class="detail-content" v-if="!isEndFlag">
      <div class="item-content">
        <span class="label">
        question
          (
          <span v-if="ruleForm.type==0">Single-choice question</span>
          <span v-if="ruleForm.type==1">Multiple Choice Questions</span>
          <span v-if="ruleForm.type==2">Judgement Questions</span>
          <span v-if="ruleForm.type==3">Fill-in-the-blank questions</span>
          )
          ({{ruleForm.score}})：
        </span>
        <span class="content">{{ruleForm.questionname}}</span>
      </div>
      <div
        v-if="(ruleForm.type==0||ruleForm.type==2)&&!isSubmitFlag"
        class="item-content"
        style="border-top:1px solid #eeeeee"
      >
        <span class="label">Select an answer：</span>
        <span class="content">
          <el-select v-model="answer">
            <el-option
              :label="item.text"
              :value="item.code"
              v-for="(item,index) in options"
              v-bind:key="index"
            ></el-option>
          </el-select>
        </span>
      </div>
      <div
        v-if="ruleForm.type==3&&!isSubmitFlag"
        class="item-content"
        style="border-top:1px solid #eeeeee"
      >
        <span class="label">Fill in the answer：</span>
        <span class="content">
          <el-input v-model="answer" style="width:300px" placeholder="Fill in the answer" clearable></el-input>
        </span>
      </div>
      <div
        v-if="ruleForm.type==1&&!isSubmitFlag"
        class="item-content"
        style="border-top:1px solid #eeeeee"
      >
        <span class="label">Select an answer：</span>
        <span class="content">
          <el-select v-model="answer" multiple>
            <el-option
              :label="item.text"
              :value="item.code"
              v-for="(item,index) in options"
              v-bind:key="index"
            ></el-option>
          </el-select>
        </span>
      </div>
      <div v-if="isSubmitFlag" class="item-content" style="border-top:1px solid #eeeeee">
        <span class="label">Fill in the answer：</span>
        <span class="content">{{answer}}</span>
      </div>
      <div v-if="isSubmitFlag" class="item-content" style="color:#888888">
        <span
          class="label"
          style="color:red;margin-right:20px"
        >{{answer==this.ruleForm.answer?'Correct':'Wrong'}}</span>
        <span class="label">Analysis：</span>
        <span class="content">{{ruleForm.analysis}}</span>
      </div>
      <div class="item-content" style="color:#888888">
        <el-button v-if="!isSubmitFlag" @click="submitTap" type="primary">Submit your answer</el-button>
        <el-button v-if="isSubmitFlag" @click="nextTap" type="success">Next</el-button>
      </div>
    </div>
    <div class="detail-content" v-if="isEndFlag">
      <div class="item-content">
        <span class="label">
          Quiz results：
          <span style="font-size:24px;font-weight:blod;color:red">{{this.score}}</span>
        </span>
        <span class="content">score</span>
      </div>
      <div class="item-content" style="color:#888888">
        <el-button @click="finishTap" type="primary">End of examination</el-button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      dataList: [],

      paper: {},

      currentIndex: 0,
      ruleForm: {},

      inter: null,

      count: 0,

      options: null,

      answer: "",

      isSubmitFlag: false,

      score: 0,
      user: {},

      isEndFlag: false
    };
  },
  computed: {
    SecondToDate: function() {
      var time = this.count;
      if (null != time && "" != time) {
        if (time > 60 && time < 60 * 60) {
          time =
            parseInt(time / 60.0) +
            "Minutes" +
            parseInt((parseFloat(time / 60.0) - parseInt(time / 60.0)) * 60) +
            "seconds";
        } else if (time >= 60 * 60 && time < 60 * 60 * 24) {
          time =
            parseInt(time / 3600.0) +
            "hours" +
            parseInt(
              (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
            ) +
            "Minutes" +
            parseInt(
              (parseFloat(
                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
              ) -
                parseInt(
                  (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                )) *
                60
            ) +
            "seconds";
        } else if (time >= 60 * 60 * 24) {
          time =
            parseInt(time / 3600.0 / 24) +
            "days" +
            parseInt(
              (parseFloat(time / 3600.0 / 24) - parseInt(time / 3600.0 / 24)) *
                24
            ) +
            "hours" +
            parseInt(
              (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
            ) +
            "Minutes" +
            parseInt(
              (parseFloat(
                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
              ) -
                parseInt(
                  (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                )) *
                60
            ) +
            "seconds";
        } else {
          time = parseInt(time) + "seconds";
        }
      }
      return time;
    }
  },
  destroyed: function() {
    window.clearInterval(this.inter);
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
    console.log(this.$route.params.id);

    var params = {
      page: 1,
      limit: 999,
      sort: "sequence",
      paperid: this.$route.params.id
    };
    this.$http({
      url: this.$api.examquestionpage,
      method: "get",
      params: params
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.dataList = data.data.list;
        this.ruleForm = this.dataList[this.currentIndex];
        this.options = JSON.parse(this.ruleForm.options);
      } else {
        this.dataList = [];
      }
      this.dataListLoading = false;
    });

    this.$http({
      url: `${this.$api.exampaperinfo}${this.$route.params.id}`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.paper = data.data;
        if (this.paper.time) {
          this.count = this.paper.time*60;
          if (this.count > 0) {
            var _this = this;
            this.inter = window.setInterval(function() {
              _this.count = _this.count - 1;
              if (_this.count < 0) {
                window.clearInterval(_this.inter);
                _this.isEndFlag = true;
              }
            }, 1000);
          }
        }
      } else {
        this.$message.error(data.msg);
      }
    });
  },
  methods: {
    leaveTap() {
      this.$confirm(`Sure to leave the exam? Unanswered questions are counted as 0 points`, "Tips", {
        confirmButtonText: "Confirm",
        cancelButtonText: "cancel",
        type: "warning"
      }).then(() => {
        this.isEndFlag = true;
      });
    },
    finishTap() {
      this.$router.go(-1);
    },
    submitTap() {
      let myscore = 0;
      if (this.ruleForm.type == 1) {
        console.log(this.answer);
        this.answer = this.answer.join(",");
      }
      this.isSubmitFlag = true;
      if (this.answer == this.ruleForm.answer) {
        this.score = Number(this.score) +Number(this.ruleForm.score) ;
        myscore = this.ruleForm.score;
      }
      console.log(this.score);

      let record = {
        userid: this.user.id,
        paperid: this.paper.id,
        papername: this.paper.name,
        questionid: this.ruleForm.id,
        questionname: this.ruleForm.questionname,
        options: this.ruleForm.options,
        score: this.ruleForm.score,
        answer: this.ruleForm.answer,
        analysis: this.ruleForm.analysis,
        myscore: myscore,
        myanswer: this.answer
      };
      this.$http({
        url: `${this.$api.examrecordsave}`,
        method: "post",
        data: record
      }).then(({ data }) => {});
    },
    nextTap() {
      if (this.currentIndex == this.dataList.length - 1) {
        this.isEndFlag = true;
      } else {
        this.currentIndex = this.currentIndex + 1;
        this.ruleForm = this.dataList[this.currentIndex];
        this.options = JSON.parse(this.ruleForm.options);
        this.isSubmitFlag = false;
      }
    }
  }
};
</script>
<style lang="scss" scoped>
.container {
  border: 1px solid #eeeeee;
}
.tip-text {
  font-size: 24px;
  color: #f96332;
}
.top-content {
  display: flex;
  justify-content: space-between;
  padding: 10px;
  font-size: 18px;
  background: #409eff;
  color: #ffffff;
  border-radius: 20px;
}
.detail-content {
  padding: 20px;
  color: #333333;
  .item-content {
    padding: 20px;
  }
}
</style>
