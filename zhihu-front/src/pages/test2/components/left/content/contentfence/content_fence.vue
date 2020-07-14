<template>
  <div id="content_fence" :style="{height:list.photo?'':'120px'}">
    <h3 id="title" @click="intoQuestion">{{ list.ques_name }}
    </h3>
    <el-dialog :title= "list.ques_name" :visible.sync="dialogVisible" width="60%">
      <p v-html="list.hotAnswer ? list.hotAnswer.answer_content:'暂无问题答案'"></p>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
    <div id="richContent" :style="{height:list.photo?'':'100px'}">
      <div id="picturePart" @click="dialogVisible = true" :style="{'display':list.photo ? '':'none'}">
        <img v-bind:src="list.photo"/>
      </div>
      <div id="shortContentPart" @click="dialogVisible = true" v-html="list.hotAnswer ? list.hotAnswer.answer_content:'暂无问题答案'" :style="list.photo ? '':ContentchangeStyle"></div>
      <div id="operationPart" :style="{'display':list.hotAnswer ? '':'none'}">
        <div id="upButton2" v-if="this.list.manner==1">
          <el-button type="text" @click="upcount" style="width:100%;padding:7px;text-align:left">
            <a class="el-icon-caret-top"/>
            <a v-html="list.hotAnswer ? '已赞同 '+(list.hotAnswer.endorse_number+count):''"></a>
          </el-button>
        </div>
        <div id="upButton" v-else>
          <el-button type="text" @click="upcount" style="width:100%;padding:7px;text-align:left">
            <i class="el-icon-caret-top"/>
            <span v-html="list.hotAnswer ? '赞同 '+(list.hotAnswer.endorse_number):''"></span>
          </el-button>
        </div>
        <div id="downButton2" v-if="this.list.manner==0">
          <el-button type="text" @click="downcount" style="width:100%;padding:7px">
            <a class="el-icon-caret-bottom"/>
          </el-button>
        </div>
        <div id="downButton" v-else>
          <el-button type="text" @click="downcount" style="width:100%;padding:7px">
            <i class="el-icon-caret-bottom"/>
          </el-button>
        </div>
        <div id="conmmentButton" @click="commentDialogVisible=true">
          <el-button type="text" style="width:100%;padding:7px;text-align:center">
            <b class="el-icon-chat-round"/>
            <b>{{ commentList.length }} 条评论</b>
          </el-button>
        </div>
        <div id="shareButton">
          <el-button type="text" style="width:100%;padding:7px;text-align:center">
            <b class="el-icon-s-promotion"/>
            <b>分享</b>
          </el-button>
        </div>
        <div id="collectButton">
          <el-button type="text" @click="openCollectDialog();getFavoritesList()" style="width:100%;padding:7px;text-align:center">
            <b class="el-icon-star-on"/>
            <b>收藏</b>
          </el-button>
        </div>
        <div id="thanksButton">
          <el-button type="text" style="width:100%;padding:7px;text-align:center">
            <b class="el-icon-user-solid"/>
            <b>感谢</b>
          </el-button>
        </div>
        <div id="othersButton">
          <el-dropdown trigger="click" style="width:100%;padding:4px;text-align:center">
            <b class="el-dropdown-link">
              <strong>···</strong>
            </b>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>没有帮助</el-dropdown-item>
              <el-dropdown-item>举报</el-dropdown-item>
              <el-dropdown-item>不感兴趣</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>
    <comments
      :question_id="question_id"
      :user_id="user_id"
      :anonymous="anonymous"
      :commentList="commentList"
      :show="commentDialogVisible"
      @close='closeCommentDialog'
      @regetComment='getComments'>
    </comments>
    <collect :show="collectDialogVisible"

             :favList="favList"
             :quesId="question_id"
             @close="closeCollectDialog"
             @openCreateCollectDialog="openCreateCollectDialog">
    </collect>
    <creatCollect :showC="creatCollectDialogVisibale"
                  @closeC="closeCreateCollectDialog"
                  @updateFav="getFavoritesList()"
    >
    </creatCollect>

  </div>

</template>

<script>
import { setAttitude, updataAttitude } from '../../../../../../api/attitude'
import { getUserFavorites } from '../../../../../../api/attent'
import creatCollect from '../../../../../zwm/createCollectDialog'
import comments from '../../../../../question/dialogs/CommentDialog'
import { getComment } from '../../../../../../api/comment.js'
import collect from '../../../../../zwm/collectionDialog'
export default {
  props: ['list'],
  components: {
    'comments': comments,
    'collect': collect,
    'creatCollect': creatCollect
  },
  data () {
    return {
      question: '',
      asker: '',
      attentionDialogVisible: false,
      commentDialogVisible: false,
      answerList: '',
      commentList: '',
      attentionList: '',
      // 问题id
      question_id: this.list.ques_id,
      // 用户id
      user_id: sessionStorage.getItem('userId'),
      // 是否匿名操作
      anonymous: false,
      invitationDialogVisible: false,
      count: this.list.manner,
      collectDialogVisible: false,
      creatCollectDialogVisibale: false,
      favList: [],
      dialogVisible: false,
      ContentchangeStyle: [{ 'margin-left': '0px' }, { '-webkit-line-clamp': '2' }, { 'width': '655px' }, { 'margin-top': '0px' }]
    }
  },
  created () {
    this.getComments()// 获取该问题的评论
    this.regetcount()
  },
  methods: {
    openCommentDialog: function () {
      this.commentDialogVisible = true
    },
    openCollectDialog: function () {
      this.collectDialogVisible = true
    },
    closeCollectDialog: function () {
      this.collectDialogVisible = false
    },
    openCreateCollectDialog: function () {
      this.creatCollectDialogVisibale = true
    },
    closeCreateCollectDialog: function () {
      this.creatCollectDialogVisibale = false
    },
    closeCommentDialog: function (num) {
      this.commentDialogVisible = false
      this.commentNum = num
    },
    intoQuestion: function () {
      sessionStorage.setItem('ques_id', this.list.ques_id)
      this.$router.push({
        name: 'Question'
      })
    },
    getComments: function () {
      let params = 'id=' + this.question_id
      getComment(params).then(res => {
        if (res.resultCode === 200) { this.commentList = res.data.commentsList }
      })
    },
    regetcount: function () {
      if (this.list.manner === 1) {
        this.count = 1
        this.list.hotAnswer.endorse_number--
      }
      if (this.list.manner === 0) {
        this.count = 1
      }
      if (this.count === 2) {
        this.count = 1
      }
    },
    upcount: function () {
      var opp
      if (this.list.manner === -1) {
        this.count = 1
        opp = 1
      } else if (this.list.manner === 1) {
        opp = 2
        this.list.manner = 2
      } else {
        opp = 1
        this.list.manner = 1
      }
      this.handleChange(opp)
    },
    downcount () {
      var opp
      if (this.list.manner === -1) {
        this.count = 0
        opp = 0
      } else if (this.list.manner === 0) {
        opp = 2
        this.list.manner = 2
      } else {
        opp = 0
        this.list.manner = 0
      }
      this.handleChange(opp)
    },
    getFavoritesList: function () {
      let params = 'id=' + this.user_id
      getUserFavorites(params).then(res => {
        if (res.resultCode === 200) {
          this.favList = res.data
        }
      })
    },
    handleChange: function (opp) {
      let params = {
        userId: sessionStorage.getItem('userId'),
        answerId: this.list.hotAnswer.answer_id,
        agrOpp: opp
      }
      // 如果之前没有点赞过——初次建立态度
      if (this.list.manner === -1) {
        setAttitude(params).then(res => {
          if (res.resultCode === 200) {
            this.list.manner = opp
            console.log(params)
          }
        })
      } else { // 否则就是更新态度
        updataAttitude(params).then(res => {
          if (res.resultCode === 200) {
            this.list.manner = opp
            console.log(params)
          }
        })
      }
    }
  }
}

</script>

<style scoped>
  #content_fence {
    padding: 20px;
    width: 655px;
    height: 180px;
    border-bottom: 1px solid #DDDDDD;
    background-color: white
  }
  h3 {
    cursor: pointer;
    width: 100%;
    margin:0;
    overflow:hidden;/*内容超出宽度时隐藏超出部分的内容 */
    text-overflow:ellipsis; /* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
    white-space:nowrap;/*不换行 */
  }
  #richContent{
    margin-top: 9px;
    width: 100%;
    height: 158px;
    background-color: white
  }
  #picturePart {
    cursor: pointer;
    vertical-align: top;
    display: inline-block;
    width: 190px;
    height: 110px;
    background-color: white;
  }
  img{
    width:190px;
    height:110px;
    border-radius:10px;
  }
  #shortContentPart {
    cursor: pointer;
    margin-top: 10px;
    vertical-align: top;
    width: 440px;
    margin-left: 20px;
    height: 55px;
    background-color: white;
    word-wrap: break-word;
    overflow: hidden;
    text-overflow:ellipsis;
    display:-webkit-inline-box;
    -webkit-box-orient:vertical;
    -webkit-line-clamp:2;
  }
  .el-button--primary {
    color: #FFFFFF;
    background-color: #045db1af;
    border-color: #606266;
  }
  .el-button--primary:hover {
    color: #FFFFFF;
    background-color: #0084ff;
    border-color: #606266;
  }
  #operationPart {
    margin-top: 10px;
    width: 100%;
    height: 32px;
    background-color: white;
  }
  #upButton {
    vertical-align: top;
    display: inline-block;
    width: 100px;
    height: 32px;
    background-color: #e5f2ff;
    border-radius:5px;
  }
  #upButton2 {
    vertical-align: top;
    display: inline-block;
    width: 100px;
    height: 32px;
    background-color: #0084ff;
    border-radius:5px;
  }
  #downButton {
    margin-left: 10px;
    vertical-align: top;
    display: inline-block;
    width: 36px;
    height: 32px;
    background-color: #e5f2ff;
    border-radius:5px;
  }
  #downButton2 {
    margin-left: 10px;
    vertical-align: top;
    display: inline-block;
    width: 36px;
    height: 32px;
    background-color: #0084ff;
    border-radius:5px;
  }
  #conmmentButton {
    margin-left: 24px;
    vertical-align: top;
    display: inline-block;
    width: 120px;
    height: 32px;
    background-color: white
  }
  #shareButton {
    margin-left: 10px;
    vertical-align: top;
    display: inline-block;
    width: 65px;
    height: 32px;
    background-color: white
  }
  #collectButton {
    margin-left: 10px;
    vertical-align: top;
    display: inline-block;
    width: 65px;
    height: 32px;
    background-color: white
  }
  #thanksButton {
    margin-left: 10px;
    vertical-align: top;
    display: inline-block;
    width: 65px;
    height: 32px;
    background-color: white
  }
  #othersButton {
    cursor:pointer;
    margin-left: 5px;
    vertical-align: top;
    display: inline-block;
    width: 40px;
    height: 32px;
    background-color: white
  }
  i{
    color: #0084ff;
  }
  span{
    color: #0084ff;
    margin-left: 5px;
  }
  a{
    color: white;
  }
  b{
    margin-left: 7px;
    color:#8590a6;
  }
  #MyFollow_bar:hover{
    background-color:#E3E3E3;
  }

#content_fence {
  padding: 20px;
  width: 655px;
  height: 180px;
  border-bottom: 1px solid #DDDDDD;
  background-color: white
}
h3 {
  cursor: pointer;
  width: 100%;
  margin:0;
  overflow:hidden;/*内容超出宽度时隐藏超出部分的内容 */
  text-overflow:ellipsis; /* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
  white-space:nowrap;/*不换行 */
}
#richContent{
  margin-top: 9px;
  width: 100%;
  height: 158px;
  background-color: white
}
#picturePart {
  cursor: pointer;
  vertical-align: top;
  display: inline-block;
  width: 190px;
  height: 110px;
  background-color: white;
}
img{
  width:190px;
  height:110px;
  border-radius:10px;
}
#shortContentPart {
  cursor: pointer;
  margin-top: 10px;
  vertical-align: top;
  width: 440px;
  margin-left: 20px;
  height: 45px;
  background-color: white;
  word-wrap: break-word;
  overflow: hidden;
  text-overflow:ellipsis;
  display:-webkit-inline-box;
  -webkit-box-orient:vertical;
  -webkit-line-clamp:4;
}
#operationPart {
  margin-top: 10px;
  width: 100%;
  height: 32px;
  background-color: white;
}
#upButton {
  vertical-align: top;
  display: inline-block;
  width: 100px;
  height: 32px;
  background-color: #e5f2ff;
  border-radius:5px;
}
#upButton2 {
  vertical-align: top;
  display: inline-block;
  width: 100px;
  height: 32px;
  background-color: #0084ff;
  border-radius:5px;
}
#downButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 36px;
  height: 32px;
  background-color: #e5f2ff;
  border-radius:5px;
}
#downButton2 {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 36px;
  height: 32px;
  background-color: #0084ff;
  border-radius:5px;
}
#conmmentButton {
  margin-left: 24px;
  vertical-align: top;
  display: inline-block;
  width: 120px;
  height: 32px;
  background-color: white
}
#shareButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 65px;
  height: 32px;
  background-color: white
}
#collectButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 65px;
  height: 32px;
  background-color: white
}
#thanksButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 65px;
  height: 32px;
  background-color: white
}
#othersButton {
  cursor:pointer;
  margin-left: 5px;
  vertical-align: top;
  display: inline-block;
  width: 40px;
  height: 32px;
  background-color: white
}
i{
  color: #0084ff;
}
span{
  color: #0084ff;
  margin-left: 5px;
}
a{
  color: white;
}
b{
  margin-left: 7px;
  color:#8590a6;
}
#MyFollow_bar:hover{
  background-color:#E3E3E3;
}
#content_fence {
  padding: 20px;
  width: 655px;
  height: 180px;
  border-bottom: 1px solid #DDDDDD;
  background-color: white
}
h3 {
  cursor: pointer;
  width: 100%;
  margin:0;
  overflow:hidden;/*内容超出宽度时隐藏超出部分的内容 */
  text-overflow:ellipsis; /* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
  white-space:nowrap;/*不换行 */
}
#richContent{
  margin-top: 9px;
  width: 100%;
  height: 158px;
  background-color: white
}
#picturePart {
  cursor: pointer;
  vertical-align: top;
  display: inline-block;
  width: 190px;
  height: 110px;
  background-color: white;
}
img{
  width:190px;
  height:110px;
  border-radius:10px;
}
#shortContentPart {
  cursor: pointer;
  margin-top: 10px;
  vertical-align: top;
  width: 440px;
  margin-left: 20px;
  height: 57px;
  background-color: white;
  word-wrap: break-word;
  overflow: hidden;
  text-overflow:ellipsis;
  display:-webkit-inline-box;
  -webkit-box-orient:vertical;
  -webkit-line-clamp:2;
}
.el-button--primary {
    color: #FFFFFF;
    background-color: #045db1af;
    border-color: #606266;
}
.el-button--primary:hover {
    color: #FFFFFF;
    background-color: #0084ff;
    border-color: #606266;
}
#operationPart {
  margin-top: 10px;
  width: 100%;
  height: 32px;
  background-color: white;
}
#upButton {
  vertical-align: top;
  display: inline-block;
  width: 100px;
  height: 32px;
  background-color: #e5f2ff;
  border-radius:5px;
}
#upButton2 {
  vertical-align: top;
  display: inline-block;
  width: 100px;
  height: 32px;
  background-color: #0084ff;
  border-radius:5px;
}
#downButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 36px;
  height: 32px;
  background-color: #e5f2ff;
  border-radius:5px;
}
#downButton2 {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 36px;
  height: 32px;
  background-color: #0084ff;
  border-radius:5px;
}
#conmmentButton {
  margin-left: 24px;
  vertical-align: top;
  display: inline-block;
  width: 120px;
  height: 32px;
  background-color: white
}
#shareButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 65px;
  height: 32px;
  background-color: white
}
#collectButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 65px;
  height: 32px;
  background-color: white
}
#thanksButton {
  margin-left: 10px;
  vertical-align: top;
  display: inline-block;
  width: 65px;
  height: 32px;
  background-color: white
}
#othersButton {
  cursor:pointer;
  margin-left: 5px;
  vertical-align: top;
  display: inline-block;
  width: 40px;
  height: 32px;
  background-color: white
}
i{
  color: #0084ff;
}
span{
  color: #0084ff;
  margin-left: 5px;
}
a{
  color: white;
}
b{
  margin-left: 7px;
  color:#8590a6;
}
#MyFollow_bar:hover{
  background-color:#E3E3E3;
}
</style>
