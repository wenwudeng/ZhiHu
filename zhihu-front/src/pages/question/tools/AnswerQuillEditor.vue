<template>
  <div v-show="doEditor" class="answerEditor">
    <div class="user-info">
      <div class="user-info-img">
        <span v-if="!anonymous">
          <el-avatar class="user_img" shape="square" fit="cover" :src="url1"/>
        </span>
        <span v-if="anonymous">
          <el-avatar class="user_img" shape="square" fit="cover" :src="url2"/>
        </span>
      </div>
      <div class="user-info-username"><b>
        <span v-if="!anonymous">{{userName}}</span>
        <span v-if="anonymous">匿名用户</span>
      </b></div>
    </div>
    <div class="edit_container">
        <quill-editor class="editor"
            v-model="content"
            ref="myQuillEditor"
            :options="editorOption"
            @blur="onEditorBlur($event)" @focus="onEditorFocus($event)"
            @change="onEditorChange($event)">
        </quill-editor>
    </div>
    <div class="submit">
      <el-button @click="saveAnswer" style="background-color: #0077e6; color: white;">
        提交回答
      </el-button>
    </div>
  </div>
</template>

<script>
import { setAnswer } from '../../../api/answer.js'
export default {
  props: ['doEditor', 'anonymous', 'user_id', 'question_id'],
  data () {
    return {
      userName: sessionStorage.getItem('userName'),
      myAnswerNum: 0,
      url1: sessionStorage.getItem('imagUrl'),
      url2: 'https://pic1.zhimg.com/da8e974dc_xs.jpg',
      content: '',
      // 定义工具栏
      editorOption: {
        modules: {
          toolbar: [
            ['bold', 'italic', 'underline', 'strike'], // 加粗，斜体，下划线，删除线
            ['blockquote'], // 引用
            // ['code-block'],     //代码块
            // [{ 'header': 1 }, { 'header': 2 }],        // 标题，键值对的形式；1、2表示字体大小
            [{ 'list': 'ordered' }, { 'list': 'bullet' }], // 列表
            [{ 'script': 'sub' }, { 'script': 'super' }], // 上下标
            // [{ 'indent': '-1'}, { 'indent': '+1' }],     // 缩进
            // [{ 'direction': 'rtl' }],             // 文本方向
            // [{ 'size': ['small', false, 'large', 'huge'] }], // 字体大小
            [{ 'header': [1, 2, 3, 4, 5, 6, false] }], // 几级标题
            [{ 'color': [] }], // 字体颜色
            // [{ 'background': [] }],     // 字体背景颜色
            // [{ 'font': [] }],     //字体
            [{ 'align': [] }], // 对齐方式
            // ['clean'],    //清除字体样式
            ['image', 'video'] // 上传图片、上传视频
          ]
        },
        theme: 'snow'

      }
    }
  },
  computed: {
    editor () {
      return this.$refs.myQuillEditor.quill
    },
    anonymity: function () {
      if (this.anonymous) { return 1 } else return 0
    }
  },
  methods: {
    onEditorReady (editor) { // 准备编辑器
    },
    onEditorBlur () {}, // 失去焦点事件
    onEditorFocus () {}, // 获得焦点事件
    onEditorChange () {}, // 内容改变事件

    saveAnswer: function (event) {
      let params = {
        userId: '' + this.user_id, // 用户的ID
        quesId: '' + this.question_id, // 问题的ID
        answerContent: this.content, // 回答的内容
        anonymity: this.anonymity// 是否匿名
      }
      setAnswer(params).then(res => {
        if (res.resultCode === 200) {
          this.$emit('regetAnswer')// 让父组件更新评论列表
        }
      })
      this.content = ''
    }
  }
}
</script>

<style>
.answerEditor{
  background-color: #ffffff;
  width: 98%;
  float: left;
  margin: 5px 0px 5px 5px;
}
.user-info-img {
  margin: 5px 5px 2px 15px;
  float: left;
}
.user-info-username {
  font-size: 20px;
  margin: 10px 5px 2px 5px;
  float: left;
}
.user-answerNum{
  font-size: 10px;
  color: #807e7e;
  float: right;
  margin: 25px 20px 5px 0px;
}
.edit_container{
  width:94%;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 2px 0px 2px 15px;
  margin-left: -8px;
}
.editor{
  float: left;
}
.submit{
    float: right;
    margin: 2px 20px 5px 0px;
}
.user_img {
  width: 40px;
  height: 40px;
}
</style>
