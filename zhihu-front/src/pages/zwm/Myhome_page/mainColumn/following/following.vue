<!--  -->
<template>
<div>
    <span v-if="userList!==undefined&&userList.length > 0">
        <div class="List-item"  v-for="(item,index) in userList" :key="index">
            <div class="ContentItem">
                <div class="ContentItem-main">
                <div class="ContentItem-image">
                    <span class="UserLink UserItem-avatar">
                        <div class="Popover">
                            <a class="UserLink-link" target="_blank" :href="item.user_link">
                            <img class="Avatar Avatar--large UserLink-avatar" width="60" height="60" :src="item.user_avaPic">
                            </a>
                        </div>
                    </span>
                </div>
                <div class="ContentItem-head">
                    <h2 class="ContentItem-title">
                        <div class="UserItem-title">
                            <span class="UserLink UserItem-name">
                                <div class="Popover">
                                    <!-- 预留点击头像跳转用户信息页面 -->
                                    <a class="UserLink-link" target="_blank" href="item.user_link">{{item.name}}</a>
                                </div>
                            </span>
                        </div>
                    </h2>
                    <div class="ContentItem-meta">
                        <div class="ContentItem-status">
                            <span class="ContentItem-statusItem">  {{item.answerNumber}} 回答</span>
                            <span class="ContentItem-statusItem">{{item.questionNumber}} 问题</span>
                            <span class="ContentItem-statusItem">{{item.followerNumber}} 关注者</span>
                        </div>
                    </div>
                </div>
                <div class="ContentItem-extra">
                    <button type="button" @click="handleUnFollow(index)" class="Button FollowButton Button--primary Button--grey">
                        <span v-if="item.focus_type==1">已关注</span>
                        <span v-if="item.focus_type!=1">关注</span>
                    </button>
                </div>
                </div>
            </div>
        </div>
    </span>
    <span v-if="userList==undefined||userList.length <= 0 ">
        <div class="EmptyState">
            <div class="EmptyState-inner">
                <i class="el-icon-user EmptyState-image" ></i>还没有关注的人喔
            </div>
        </div>
    </span>
</div>
</template>

<script>
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';

import { getConcern, deleteAttentionUser } from '../../../../../api/attent.js'
export default {
// import引入的组件需要注入到对象中才能使用
  components: {},
  data () {
    // 这里存放数据
    return {
      userList: [],
      userId: sessionStorage.getItem('userId')
    // items:[
    //     {
    //         user_name : '影坛XX',user_avaPic : 'https://pic2.zhimg.com/v2-325169edb5dd682cd6d9212a72950c6b_im.jpg',
    //         user_link :  '//www.zhihu.com/people/zhao-si-ji-36' , user_ansNum : '688' , user_artNum : '6',
    //         user_followNum : '17777' , following_statue : '已关注'
    //     },{
    //         user_name : '迪奥',user_avaPic : 'https://pic3.zhimg.com/v2-52c06b18b76a25191b91a11873b8828f_im.jpg',
    //         user_link :  '//www.zhihu.com/people/zhao-si-ji-36' , user_ansNum : '551' , user_artNum : '3',
    //         user_followNum : '12460' , following_statue : '已关注'
    //     }
    // ]
    }
  },
  // 方法集合
  methods: {
    loadConcern  () {
      let params = 'id=' + this.userId
      getConcern(params).then(res => {
        if (res.resultCode === 200) {
          this.userList = res.data
          console.log(res.data)
        }
      })
    },
    handleUnFollow (index) {
    //   this.userList[index].focus_type = !this.userList[index].focus_type
      let params = {
        userId: this.userId,
        focusId: this.userList[index].Focus_id
      }
      deleteAttentionUser(params).then(res => {
        if (res.resultCode === 200) {
          this.testList = res.data
          this.userList.splice(index, 1)
          alert('取消关注成功')
        }
      })
    }

  },
  created () {
    this.loadConcern()
  }
}
</script>
<style scoped>
.List-item {
    position: relative;
    padding: 16px 20px;
}
.ContentItem-main {
    display: flex;
}
.ContentItem-image {
    float: left;
    margin-right: 16px;
}
.UserItem-avatar .Popover {
    display: block;
}
.Popover {
    position: relative;
    display: inline-block;
}
a {
    color: inherit;
    text-decoration: none;
}
.UserItem-avatar .Avatar, .UserItem-avatar .Popover {
    display: block;
}
.ContentItem-head {
    -webkit-box-flex: 1;
    flex: 1 1;
    overflow: hidden;
    margin-right: 6px;
}
.ContentItem-title {
    font-size: 18px;
    font-weight: 600;
    line-height: 1.6;
    color: #1a1a1a;
    margin-top: -4px;
    margin-bottom: -4px;
}
.UserItem-name, .UserItem-name .UserLink-badge, .UserItem-title {
    display: flex;
}
.ContentItem-meta {
    font-size: 15px;
    margin-top: 6px;
    color: #646464;
}
.ContentItem-status {
    margin-top: 5px;
    color: #8590a6;
    font-size: 14px;
}
.ContentItem-statusItem:not(:first-child):before {
    margin: 0 5px;
    content: "\B7";
}
.ContentItem-extra {
    -ms-flex-item-align: center;
    align-self: center;
}
.Button--primary.Button--grey {
    color: #fff;
    background-color: #8590a6;
}
.FollowButton {
    min-width: 96px;
}
.Button--grey {
    color: #8590a6;
    border-color: #8590a6;
}
.Button {
    display: inline-block;
    padding: 0 16px;
    font-size: 14px;
    line-height: 32px;
    color: #8590a6;
    text-align: center;
    cursor: pointer;
    background: none;
    border: 1px solid;
    border-radius: 3px;
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
</style>
