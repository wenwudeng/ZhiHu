<template>
  <div id="content_bar">
      <div id="top_num">
        {{contentlist.number}}
      </div>
      <div id="content"><!-- :style="{background:true?'#000000':'#FFFFFF'}" -->
        <div id="top_title" @click="intoQuestion" :style="{width:true?'':'200px'}">
          {{contentlist.ques_name}}
        </div>
        <div id="content_intro" @click="intoQuestion" :style="{width:contentlist.ques_name?'':'200px'}">
          <a v-html="contentlist.ques_describe"/>
        </div>
        <div id="content_hot">
          <i class="el-icon-sunrise-1"/>
          <span>{{ contentlist.heat }}万热度</span>
        </div>
        <div id="share_button">
          <i class="el-icon-position"/>
          <span>分享</span>
        </div>
      </div>
      <div id="picture" @click="intoQuestion" :style="{'display':contentlist.photo ? '':'none'}">
        <img v-bind:src="contentlist.photo"/>
      </div>
    </div>
</template>

<script>
export default {
  props: ['contentlist'],
  methods: {
    intoQuestion: function () {
      sessionStorage.setItem('ques_id', this.contentlist.ques_id)
      this.$router.push({
        name: 'Question'
        // params:{
        //  qid:this.list.quesId
        // }
      })
    }
  }
}
</script>
<style scoped>
#content_bar{
  border-top: 1px solid #DDDDDD;
  padding: 10px;
  height: 130px;
  width: 675px;
  background-color: white;
}
#top_num{
  font-weight: bold;
  vertical-align: top;
  display: inline-block;
  margin-left: 10px;
  width:30px;
  height: 30px;
  color: orange;
}
#top_title{
  cursor:pointer;
  font-weight: bold;
  display: inline-block;
  width:400px;
  height: 30px;
  background-color: white;
}
#picture{
  cursor:pointer;
  vertical-align: top;
  display: inline-block;
  margin-left: 20px;
  height: 100px;
  width: 180px;
}
img{
  height: 100px;
  width: 180px;
  border-radius:10px;
}
#content{
  margin-left: 20px;
  display: inline-block;
  vertical-align: top;
  width: 400px;
  height: 100px;
  background-color: white;
}
#content_intro{
  cursor:pointer;
  width: 400px;
  height: 56px;
  background-color: white;
    word-wrap: break-word;
  overflow: hidden;
  text-overflow:ellipsis;
  display:-webkit-inline-box;
  -webkit-box-orient:vertical;
  -webkit-line-clamp:2;
}
#content_hot{
  padding: 5px;
  display: inline-block;
  vertical-align: top;
  background-color: white;
  width:130px;
  height: 20px;
}
i{
  color:#8590a6;
}
span{
  color:#8590a6;
}

#share_button{
  cursor:pointer;
  padding: 5px;
  display: inline-block;
  vertical-align: top;
  background-color: white;
  width:60px;
  height: 20px;
}
</style>
