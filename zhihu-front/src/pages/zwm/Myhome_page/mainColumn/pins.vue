<!-- 想法页 -->
<template>
                <div  class="ListShortcut" id="ListShortcut" >

                  <div class="List ProfileActivities">
                    <!-- hearder -->
                    <div class="List-header">
                      <h4  class="List-headerText">
                        <span>我的想法</span>
                      </h4>
                    </div>
                    <!-- 如果得到的列表不为空则显示我的想法 -->
                    <span v-if="items!==undefined&&items.length > 0">
                    <!-- 想法详情 -->
                    <div class>
                      <div  class="List-item" tabindex="0" v-for="(item,index) in items" :key="index">

                        <!-- 想法详细信息 -->
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
                               {{item.agree_num}} 人赞同了该回答
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
                              <el-button class="Button VoteButton VoteButton--up" type="primary" plain icon="el-icon-caret-top" disabled>赞同 {{item.button_voteup_num}}</el-button>
                            </span>
                            <button type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-chat-round"></i>  {{item.comment_num}} 条评论
                            </button>
                            <button type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-position"></i>  分享
                            </button>
                            <button type="button" class="Button ContentItem-action Button--plain Button--withIcon Button--withLabel">
                              <i class="el-icon-star-on"></i>  收藏
                            </button>
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
                    </span>

                    <!-- 若返回的数组为空则显示没有想法喔 -->
                    <span v-if="items==undefined||items.length <= 0 ">
                      <div class="EmptyState">
                        <div class="EmptyState-inner">
                          <i class="el-icon-tickets EmptyState-image" ></i>还没有想法
                        </div>
                      </div>
                    </span>
                  </div>
                </div>
</template>

<script>
export default {
// import引入的组件需要注入到对象中才能使用
  components: {},
  data () {
    // 这里存放数据
    return {
      items: []
    }
  },

  // 方法集合
  methods: {

  },
  created () {
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
.EmptyState {
    display: flex;
    -webkit-box-align: center;
    align-items: center;
    -webkit-box-pack: center;
    justify-content: center;
    -webkit-box-flex: 1;
    flex: 1 1;
    height: 100%;
    padding: 70px 0;
}
.EmptyState-inner {
    font-size: 15px;
    color: #8590a6;
    text-align: center;
}
.EmptyState-image {
    display: block;
    margin: 20px;
    font-size: 50px;
}
.EmptyState-action{
    color: #175199;
}
</style>
