<template>
  <div class="home-comment">
    <div class="title">UserLeave</div>
    <div class="comment-list">
      <div v-for="(item,index) in list"  v-bind:key="index" class="comment-item">
        <div class="user-content">
          <el-image
            class="avator"
            :src="item.avator"
          ></el-image>
          <span class="user">{{item.name}}</span>
        </div>
        <div class="comment">{{item.content}}</div>
        <div class="create-time">{{item.createTime}}</div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      list: [
        {
          name: "MaskLin",
          avator:
            "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          content:
            "",
          createTime: ""
        },
        {
          name: "MaskLin",
          avator:
            "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          content: "",
          createTime: ""
        },
        {
          name: "MaskLin",
          avator:
            "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          content: "",
          createTime: ""
        },
        {
          name: "MaskLin",
          avator: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
          content: "",
          createTime: ""
        }
      ]
    };
  }
};
</script>
<style lang="scss" scoped>
.home-comment {
  background: #ffffff;
  .title {
    font-size: 18px;
    color: #666;
    font-weight: bold;
    padding: 10px;
    border-bottom: 1px solid #eeeeee;
  }
  .comment-list {
    padding: 10px;
    .comment-item {
      padding: 10px;
      border-bottom: 1px solid #eeeeee;
      .user-content {
        display: flex;
        align-items: center;
        .user {
          font-size: 18px;
          color: #666;
          font-weight: bold;
          line-height: 50px;
          margin-left: 10px;
        }
        .avator {
          width: 50px;
          height: 50px;
          border-radius: 50%;
        }
      }
      .comment {
        margin-top: 10px;
        font-size: 14px;
        color: #888888;
      }
      .create-time {
        margin-top: 15px;
        font-size: 14px;
        color: #888888;
      }
    }
  }
}
</style>
