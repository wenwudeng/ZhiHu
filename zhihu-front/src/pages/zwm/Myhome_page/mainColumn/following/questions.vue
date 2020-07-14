<!--  -->
<template>
<div>
    <div class="List-item" v-for="(item,index) in quesList" :key="index" >
        <div class="ContentItem">
            <h2 class="ContentItem-title">
                <div class="QuestionItem-title">
                    <span @click="intoQuestion(item.ques_id)">{{item.ques_name}}</span>
                </div>
            </h2>
            <div class="ContentItem-status">
                <span class="ContentItem-statusItem" v-text="showTime(item.create_time)"></span><br>
                <span class="ContentItem-statusItem1">{{item.answerNumber}} 个回答</span>
                <span class="ContentItem-statusItem1">{{item.attentionNumber}} 个关注</span>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import { getAttentionQues } from '../../../../../api/attent.js'
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';

export default {
// import引入的组件需要注入到对象中才能使用
  components: {},
  data () {
    // 这里存放数据
    return {
      quesList: []

    // [
      ///   {   title : '有哪些句子是真正写到你心里去了？', creattime : '2018-06-22' , ansNum : 22545 , followed : 198974 },
      // {   title : '程序员一定会脱发吗？', creattime : '2019-06-22' , ansNum : 6548 , followed : 52213 },
      //
      // ]
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {
    getQues: function () {
      let params = 'id=' + sessionStorage.getItem('userId')
      getAttentionQues(params).then(res => {
        if (res.resultCode === 200) {
          this.quesList = res.data
        }
      })
    },
    // 处理时间
    // eslint-disable-next-line camelcase
    showTime: function (create_time) {
      var date = create_time.substring(0, 10)
      var time = create_time.substring(11, 19)
      return '创建时间' + date + '   ' + time
    },
    // 跳转到该问题的页面
    // eslint-disable-next-line camelcase
    intoQuestion: function (ques_id) {
      // alert(ques_id);
      sessionStorage.setItem('ques_id', ques_id)
      this.$router.push({
        name: 'Question'
      })
    }
  },
  created () {
    this.getQues()
  }
}
</script>
<style scoped>
.List-item {
    position: relative;
    padding: 16px 20px;
}
.ContentItem-title {
    font-size: 18px;
    font-weight: 600;
    line-height: 1.6;
    color: #1a1a1a;
    margin-top: -4px;
    margin-bottom: 5px;
}
.QuestionItem-title {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
}
h2 {
    display: block;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
    margin: 0;
    font: inherit;
}
a {
    color: inherit;
    text-decoration: none;
}
.ContentItem-status {
    margin-top: 5px;
    color: #8590a6;
    font-size: 14px;
}
.ContentItem-statusItem1{
     margin: 15px 10px 5px 5px;
    content: "\B7";
}

</style>
