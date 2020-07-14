<!--  -->
<template>
  <!-- 用于填充header -->
  <div id="root">
      <vheader> </vheader>

      <main role="main" class="App-main">
        <!-- 头像背景等部分 -->
          <div class="ProfileHeader" >
              <div class="Card">
                  <div class="ProfileHeader-userCover">
                      <div class="UserCoverEditor">
                        <div>
                            <label class="UploadPicture-wrapper">
                            <div class="UserCoverGuide">
                              <div class="UserCoverGuide-inner">
                              <div class="UserCoverGuide-buttonContainer">
                                  <button type="button" class="Button DynamicColorButton DynamicColorButton--dark">
                                    <i class="el-icon-camera" style="width:14px;height:16px;"></i>
                                    上传封面图片
                                  </button>
                              </div>
                              </div>
                            </div>
                           </label>
                            <div class="UserCover UserCover--colorBlock"></div>
                        </div>
                      </div>
                  </div>

          <!-- 框主体内容 -->
              <div class="ProfileHeader-wrapper">
                <div class="ProfileHeader-main">
                  <!-- 头像区域 -->
                  <div class="UserAvatarEditor ProfileHeader-avatar" style="top:-74px">
                    <div class="UserAvatar">
                      <img :src="imagUrl"  width="160" height="160">
                    </div>
                  </div>

                  <!-- 用户信息区域 -->
                  <div class="ProfileHeader-content">
                    <div class="ProfileHeader-contentHead">
                      <h1 class="ProfileHeader-title">
                        <span class="ProfileHeader-name">{{account.name}}</span>
                        <span class="ztext ProfileHeader-headline">{{account.professional}}</span>
                      </h1>
                    </div>
                    <div class="ProfileHeader-contentBody" style="overflow: hidden; transition: height 300ms ease-out 0s; height: 43px;">
                        <div class="ProfileHeader-detail">
                            <div class="ProfileHeader-detailItem">
                              <span class="ProfileHeader-detailLabel">所在行业</span>
                              <div class="ProfileHeader-detailValue">{{account.industry}}</div>
                            </div>
                        </div>
                    </div>
                    <div class="ProfileHeader-contentFooter">
                      <div class="ProfileButtonGroup ProfileHeader-buttons">
                        <router-link to="/edit"><button type="button" class="Button Button--blue">编辑个人资料</button></router-link>
                      </div>
                    </div>
                  </div>

                </div>
              </div>
             </div>
          </div>

          <div class="Profile-main">
            <div class="Profile-mainColumn">
              <div class=" Card ProfileMain">
                <!-- 顶部活动选择栏 -->
                <div class="ProfileMain-header">
                  <ul  class="Tabs ProfileMain-tabs">

                    <li class="Tabs-item">
                      <router-link to="/MyHomePage/activity"><a class="Tabs-link">动态</a></router-link>
                    </li>
                    <li class="Tabs-item">
                      <router-link to="/MyHomePage/answer"><a class="Tabs-link">回答<span class="Tabs-meta">0</span></a></router-link>
                    </li>
                    <li class="Tabs-item">
                      <router-link to="/MyHomePage/askQuesttion"><a class="Tabs-link">提问<span class="Tabs-meta">0</span></a></router-link>
                    </li>
                    <li class="Tabs-item">
                      <router-link to="/MyHomePage/article"><a class="Tabs-link">文章<span class="Tabs-meta">0</span></a></router-link>
                    </li>
                    <li class="Tabs-item">
                      <router-link to="/MyHomePage/columns"><a class="Tabs-link">专栏<span class="Tabs-meta">0</span></a></router-link>
                    </li>
                    <li class="Tabs-item">
                      <router-link to="/MyHomePage/pins"><a class="Tabs-link">想法<span class="Tabs-meta">0</span></a></router-link>
                    </li>
                    <li class="Tabs-item">
                      <div class="Popover Tabs-link">
                        <el-dropdown>
                          <span class="el-dropdown-link Tabs-link" style="padding:0">
                            更多<i class="el-icon-arrow-down el-icon--right"></i>
                          </span>
                          <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>收藏</el-dropdown-item>
                            <router-link to="/MyHomePage/following"><el-dropdown-item>关注</el-dropdown-item></router-link>
                          </el-dropdown-menu>
                        </el-dropdown>
                      </div>
                    </li>

                  </ul>
                </div>
                <div></div>

                <!-- 根据选择后显示的部分 -->
                <!-- <mainColumn></mainColumn> -->
                <keep-alive>
                    <router-view></router-view>
                </keep-alive>

              </div>
              <!-- 显示右边柱的信息 -->

            </div>
            <sideColumn></sideColumn>
          </div>

      </main>

  </div>

</template>

<script>
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
import sideColumn from './Myhome_page/homepage_sideColumn'
import vheader from './vheader'
export default {
// import引入的组件需要注入到对象中才能使用
  components: {
    'sideColumn': sideColumn,
    'vheader': vheader
  },
  data () {
    // 这里存放数据
    return {
      account: {
        name: sessionStorage.getItem('userName'),
        professional: '软件工程',
        // 行业
        industry: '软件开发',
        imagUrl: sessionStorage.getItem('imagUrl'),
        userId: sessionStorage.getItem('userId')
      }
    }
  },

  methods: {

  },
  beforeMount () {
    this.userId = sessionStorage.getItem('userId')
    this.imagUrl = sessionStorage.getItem('imagUrl')
    console.log(this.imagUrl)
  }
}

</script>

<style  scoped>
.app-header{
    position: relative;
    z-index: 100;
    height: 52px;
    min-width: 1032px;
    overflow: hidden;
    background: rgb(23, 202, 98);
    -webkit-box-shadow: 0 1px 3px rgba(26,26,26,.1);
    box-shadow: 0 1px 3px rgba(26,26,26,.1);
    background-clip: content-box;
}
.App-main{
    display: block;
}
.ProfileHeader{
  position: relative;
  width : 1000px;
  padding: 0 16px;
  margin: 10px auto;
  display: block;
}
.Card:last-child{
  margin-bottom: 0;
}
.Card{
  margin-bottom: 10px;
  background: #fff;
  overflow: hidden;
  -webkit-box-shadow: 0 1px 3px rgba(26,26,26,.1);
  box-shadow: 0 1px 3px rgba(26,26,26,.1);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
.UserCoverEditor {
    position: relative;
    display: block;
}
.UploadPicture-wrapper {
    cursor: pointer;
}
.UploadPicture-input {
    display: none;
}
.UserCoverGuide {
    position: absolute;
    z-index: 2;
    width: 100%;
    height: 100%;
    overflow: hidden;
    border-top-right-radius: 1px;
    border-top-left-radius: 1px;
}

.UserCoverGuide-buttonContainer {
    margin-bottom: 14px;
    text-align: right;
}
.UserCoverGuide-inner {
    position: relative;
    z-index: 2;
    float: right;
    padding: 24px;
}
.DynamicColorButton {
    color: #d3d3d3;
    -webkit-transition: color,border-color .3s;
    transition: color,border-color .3s;
}
.Button {
    display: inline-block;
    padding: 0 16px;
    font-size: 14px;
    line-height: 32px;
    text-align: center;
    cursor: pointer;
    background: none;
    border: 1px solid;
    border-radius: 3px;

}
.UserCover {
    position: relative;
    height:240px;
    overflow: hidden;
    background: #f6f6f6;
    border-top-right-radius: 1px;
    border-top-left-radius: 1px;
    -webkit-transition: height .3s;
    transition: height .3s;
}
.UserCover--colorBlock {
    height: 132px;
    background: #999;
}

/* 主题部分底部样式 */
.ProfileHeader-wrapper {
    position: relative;
    width: 100%;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.ProfileHeader-main {
    position: relative;
    margin: 0 20px 24px;
    display: block;
}
.ProfileHeader-avatar {
    position: absolute;
    top: -25px;
    left: 0;
    z-index: 1;
}
.UserAvatar {
    display: inline-block;
    overflow: hidden;
    vertical-align: top;
    background-color: #fff;
    border: 4px solid #fff;
    border-radius: 8px;
}
.ProfileHeader-content {
    padding-top: 16px;
    padding-left: 32px;
    border-left: 164px solid transparent;
}
.ProfileHeader-contentHead {
    position: relative;
    padding-right: 106px;
    margin-bottom: 16px;
}
.ProfileHeader-name {
    font-size: 26px;
    font-weight: 600;
    font-synthesis: style;
    line-height: 30px;
}
.ProfileHeader-title {
    -webkit-box-flex: 1;
    -ms-flex: 1 1;
    flex: 1 1;
    margin: 0;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
h1 {
    display: block;
    font-size: 2em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.ProfileHeader-headline {
    margin-left: 12px;
    font-size: 18px;
    white-space: nowrap;
    font-weight: normal;
}
.ztext {
    word-break: break-word;
    line-height: 1.6;
}

/* 个人资料样式 */
.ProfileHeader-contentBody {
    position: relative;
    width: 524px;
    overflow: hidden;
}
.ProfileHeader-detail {
    width: 100%;
    font-size: 14px;
    line-height: 1.8;
    color: #1a1a1a;
}
.ProfileHeader-detailItem {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    margin-bottom: 18px;
}
.ProfileHeader-detailLabel {
    width: 60px;
    margin-right: 37px;
    font-weight: 600;
}
.ProfileHeader-contentFooter {
    position: relative;
    padding-top: 8px;
}
.ProfileHeader-buttons {
    position: absolute;
    right: 0;
    bottom: 0;
}
.Button--blue {
    color: #0084ff;
    border-color: #0084ff;
}

/* 主体部分，分类导航栏区域 */
.Profile-main {
    display: flex;
    width: 1000px;
    min-height: 100vh;
    padding: 0 16px;
    margin: 10px auto;
    -webkit-box-pack: justify;
    justify-content: space-between;
    -webkit-box-align: start;
    align-items: flex-start;
}
.ProfileMain {
    overflow: initial;
}
.Profile-mainColumn {
    width: 694px;
    margin-bottom: 0;
}
.ProfileMain-tabs {
    -webkit-box-flex: 1;
    -ms-flex: 1 1;
    flex: 1 1;
}
.Tabs-item {
    display: inline-block;
    padding: 0 20px;
}
ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
    padding: 0;
    margin: 0;
}
li {
    list-style-type: none;
}
.Tabs-link {
    position: relative;
    display: inline-block;
    padding: 14px 0;
    font-size: 16px;
    line-height: 22px;
    color: #1a1a1a;
    text-align: center;
}
.Tabs-meta {
    margin-left: 6px;
    font-size: 14px;
    font-weight: 300;
    line-height: 20px;
    color: #999;
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
.VoteButton--down {
    margin-left: 2px;
}
.ContentItem-action {
    margin-left: 24px;
    font-size: 15px;
}
</style>
