<!--动态页  -->
<template>
                <div class="ListShortcut" id="ListShortcut" >
                  <div class="List ProfileActivities">
                    <!-- hearder -->
                    <div class="List-header">
                      <h4  class="List-headerText">
                        <span>我的动态</span>
                      </h4>
                    </div>
                    <!-- 动态详情 -->
                    <div class>
                      <div  class="List-item" tabindex="0" v-for="(item,index) in items" :key="index">
                        <!-- 动态的分类和头部信息-->
                        <div class="List-itemMeta">
                          <div class="ActivityItem-meta">
                            <span class="ActivityItem-metaTitle">收藏了{{item.type}}</span>
                            <span>{{item.time}}个小时前</span>
                          </div>
                        </div>
                        <!-- 动态详细信息 -->
                        <div class="ContentItem AnswerItem">
                          <h2 class="ContentItem-title">
                            <a target="_blank" href="">{{item.title}}</a>
                          </h2>
                        </div>
                        <div class="ContentItem-meta">
                          <div class="AuthorInfo AnswerItem-authorInfo">
                            <span class="UserLink AuthorInfo-avatarWrapper">
                              <div class="Popover">
                                <img :src="item.author_avater" height="38px" width="38px">
                              </div>
                            </span>
                            <div class="AuthorInfo-content">
                              <div class="AuthorInfo-head">
                                <a href="" target="_blank">{{item.author_name}}</a>
                              </div>
                              <div class="AuthorInfo-detail">
                                <div class="AuthorInfo-badge">
                                  <div class="ztext AuthorInfo-badgeText">
                                    {{item.author_detail}}</div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="AnswerItem-extraInfo">
                            <span class="Voters">
                              <button type="button" class="Button Button--plain">
                               {{item.agree_num}}人赞同了该{{item.type}}
                              </button>
                            </span>
                          </div>
                        </div>

                        <div class="RichContent is-collapsed">
                          <div class="RichContent-cover">
                            <div class="RichContent-cover-inner">
                              <img :src="item.content_cover">
                            </div>
                          </div>
                          <div class="RichContent-inner">
                            <span class="RichText ztext CopyrightRichText-richText">
                              {{item.content_text}}
                            </span>
                            <button type="button" class="Button ContentItem-more Button--plain">
                              阅读原文
                            <i class="el-icon-arrow-down el-icon--right"></i>
                            </button>
                          </div>
                          <div class="ContentItem-actions">
                            <span>
                              <el-button class="Button VoteButton VoteButton--up" type="primary" plain icon="el-icon-caret-top">赞同 {{item.button_voteup_num}}</el-button>
                              <el-button class="Button VoteButton VoteButton--down" type="primary" plain icon="el-icon-caret-bottom"></el-button>
                            </span>
                            <button type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-chat-round"></i>  {{item.comment_num}} 条评论
                            </button>
                            <button type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-position"></i>  分享
                            </button>

                            <button @click="openCollectDialog();getFavoritesList()" type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-star-on"></i>  收藏
                            </button>
                            <collect></collect>

                            <button type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-thumb"></i>  感谢
                            </button>
                            <el-dropdown trigger="click">
                            <button type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-more"></i>
                            </button>
                            <el-dropdown-menu slot="dropdown">
                              <el-dropdown-item >没有帮助</el-dropdown-item>
                              <el-dropdown-item >举报</el-dropdown-item>
                              <el-dropdown-item >申请授权</el-dropdown-item>
                            </el-dropdown-menu>
                          </el-dropdown>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
        <collect :show="collectDialogVisible"
         :favList="favList"
         @close="closeCollectDialog"
         @openCreateCollectDialog="openCreateCollectDialog"
         @updateFav="getFavoritesList()">
         </collect>

        <creatCollect :showC="creatCollectDialogVisibale"
         @closeC="closeCreateCollectDialog"
         @updateFav="getFavoritesList()"
        >
         </creatCollect>

                </div>

</template>

<script>
import creatCollect from '../../createCollectDialog'
import collect from '../../collectionDialog'
import { getUserFavorites } from '../../../../api/attent.js'
export default {
// import引入的组件需要注入到对象中才能使用
  components: {
    'collect': collect,
    'creatCollect': creatCollect
  },
  data () {
    // 这里存放数据
    return {
      collectDialogVisible: false,
      creatCollectDialogVisibale: false,
      favList: [],
      userId: sessionStorage.getItem('userId'),
      collectList: [
        { name: '日常', num: 8, collectState: false },
        { name: '动漫', num: 5, collectState: false },
        { name: '日常', num: 8, collectState: true }
      ],

      items: [
        { type: '回答',
          time: '10',
          title: '有哪些温暖可爱的句子？',
          author_avater: 'https://pic3.zhimg.com/50/v2-cc7f70ee77d16125ae27144eb2bfb5a5_xs.jpg',
          author_name: '桃花不换酒',
          author_detail: '今天午睡了吗！',
          agree_num: '30774',
          content_cover: 'https://pic2.zhimg.com/50/v2-3aeae151545f6cb839a70f737caf54cf_400x224.jpg',
          content_text: '1.“睡不着，在数羊的时候，突然有一只小羊站了出来对我说“请你用心一点，你已经数过我一次了。” 2.：“如果夜里不能吃东西，那冰箱里为什么会有灯呢？”♡ 3:“最近有谁生日吗 生日愿望能不能许我的破脸不要…',
          button_voteup_num: '30K',
          comment_num: 125 },
        { type: '回答',
          time: '18',
          title: '有什么好用的学习类App？',
          author_avater: 'https://pic4.zhimg.com/50/686a46fb56cc014a869f9a295cefba7f_xs.jpg',
          author_name: '邵云蛟',
          author_detail: '微信公众号【旁门左道PPT】作者！分享更多原创PPT设计经验',
          agree_num: '2872',
          content_cover: 'https://pic3.zhimg.com/50/v2-c0744c6d25d33e84b47f97f94577c715_400x224.jpg',
          content_text: '分享9个超小众，但巨好用的学习类APP！一旦打开让你不自觉开始学习，比抖音更容易上瘾!最近喜欢一句话：别赢在了高考，却输在了大学！职场上也是一样的，如果停止了学习，很容易被超越！但有的时候有很反感学习…',
          button_voteup_num: '2.9K',
          comment_num: 69
        },
        { type: '文章',
          time: '23',
          title: '一集上瘾的成人动漫你知道哪些？',
          author_avater: 'https://pic1.zhimg.com/50/v2-ad6489236e8fdad15b536d4f82539809_xs.jpg',
          author_name: '君君',
          author_detail: '微信公众号【君君电影院】，有你想看的',
          agree_num: '5842',
          content_cover: 'https://pic1.zhimg.com/50/v2-7fe0fc106545b84e170da98c6d1d9190_400x224.jpg',
          content_text: '前段时间，一部网飞成人动画火遍全网！——《爱，死亡和机器人》。被无数网友奉为神作，豆瓣评分曾飙一举到9.5。大尺度、黑暗系的风格，让人又爱又怕！…',
          button_voteup_num: '5.8K',
          comment_num: 25
        }
      ]

    }
  },

  // 方法集合
  methods: {
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
    getFavoritesList: function () {
      let params = 'id=' + this.userId
      getUserFavorites(params).then(res => {
        if (res.resultCode === 200) {
          this.favList = res.data
          console.log(this.favList)
        }
      })
    }

  }
}
</script>
<style  scoped>
/* 动态的列表显示 */
.List-item {
    position: relative;
    padding: 16px 20px;
}
.List-itemMeta {
    margin-bottom: 10px;
    color: #8590a6;
    font-size: 15px;
}
.ActivityItem-meta {
    display: flex;
}
.ActivityItem-metaTitle {
    -webkit-box-flex: 1;
    flex: 1 1;
}
.ContentItem-title {
    font-size: 18px;
    font-weight: 600;
    line-height: 1.6;
    color: #1a1a1a;
    margin-top: -4px;
    margin-bottom: -4px;
}
 h2{
    margin: 0;
    font: inherit;
    display: block;
    font-size: 1.5em;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.ContentItem-meta {
    margin-top: 6px;
    font-size: 15px;
    color: #646464;
}
.AnswerItem-authorInfo {
    margin-top: 10px;
}
.AuthorInfo {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
}
.Popover {
    position: relative;
    display: inline-block;
}
.AuthorInfo-content {
    -webkit-box-flex: 1;
    flex: 1 1;
    margin-left: 14px;
    overflow: hidden;
}
.AuthorInfo-head {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    font-size: 15px;
    line-height: 1.1;
    flex-shrink: 0;
}
.AuthorInfo-detail {
    overflow: hidden;
}
.AnswerItem-extraInfo {
    margin-top: 10px;
    margin-bottom: -4px;
    font-size: 14px;
    color: #8590a6;
}
.AuthorInfo-name {
    font-weight: 600;
    color: #444;
}
.AuthorInfo-badge {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    margin-top: 2px;
    font-size: 14px;
}
.AuthorInfo-badgeText {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    color: #646464;
}
.Voters {
    color: #8590a6;
}
.Button--plain {
    height: auto;
    padding: 0;
    line-height: inherit;
    background-color: transparent;
    border: none;
    border-radius: 0;
    color: #8590a6;
}
.RichContent {
    line-height: 1.67;
    display: block;
    font-size: 15px;
}
.RichContent-cover {
    position: relative;
    width: 190px;
    height: 105px;
    margin-top: -2px;
    margin-right: 18px;
    margin-bottom: 4px;
    float: left;
    overflow: hidden;
    background-position: 50%;
    background-size: cover;
    border-radius: 4px;
    transform: translateZ(0);
}
.RichContent-cover-inner {
    position: absolute;
    top: 50%;
    left: 0;
    height: 100%;
    width: 100%;
    -webkit-transform: translateY(-50%);
    transform: translateY(-50%);
    overflow: hidden;
}
.RichContent-cover-inner img {
    position: absolute;
    top: 50%;
    left: 50%;
    width: 100%;
    transform: translate3d(-50%,-50%,0);
}
.RichContent-cover+.RichContent-inner {
    margin-top: 16px;
}
.RichContent.is-collapsed .RichContent-inner {
    max-height: 100px;
}
.ContentItem-more {
    padding: 0;
    margin-left: 4px;
    color: #175199;
}
.ContentItem-actions {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    padding: 10px 20px;
    margin: 0 -20px -10px;
    color: #646464;
    background: #fff;
    clear: both;
}
.VoteButton {
    padding: 0 10px;
    color: #0084ff;
    background: rgba(0,132,255,.1);
    border-color: transparent;
}
.Button {

    display: inline-block;
    font-size: 14px;
    line-height: 32px;
    text-align: center;
    cursor: pointer;

    border-radius: 3px;
}
 button {
    margin: 0;
}
.VoteButton--down {
    margin-left: 2px;
}
.ContentItem-action {
    margin-left: 24px;
    font-size: 15px;
}
a {
     color: inherit;
    text-decoration: none;
}
.List-header {
    display: flex;
    -webkit-box-pack: justify;
    justify-content: space-between;
    -webkit-box-align: center;
    align-items: center;
    height: 50px;
    margin: 0 20px;
    border-bottom: 1px solid #f6f6f6;
    box-sizing: border-box;
}
.List-headerText {
    margin: 0;
}
h4 {
    display: block;
    margin-block-start: 1.33em;
    margin-block-end: 1.33em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}

</style>
