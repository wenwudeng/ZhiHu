<!-- 关注页 -->
<template>
<div class='ListShortcut'>
    <div class="List" id="Profile-following">
        <div class="List-header">
            <h4 class="List-headerText">
                <div class="SubTabs">
                    <router-link to="/MyHomePage/following"><a class="SubTabs-item" href="">我关注的人</a></router-link>
                    <router-link to="/MyHomePage/followers"><a class="SubTabs-item" href="">关注我的人</a></router-link>
                    <span class="SubTabs-item">
                        <div class="Popover">
                            <el-dropdown>
                            <button class="el-dropdown-link Tabs-link Button Select-button Select-plainButton Button--plain" style="padding:0">
                                更多<i class="el-icon-arrow-down el-icon--right"></i>
                            </button>
                            <el-dropdown-menu slot="dropdown">
                                <router-link to="/MyHomePage/topics"><el-dropdown-item>我关注的话题</el-dropdown-item></router-link>
                                <router-link to="/MyHomePage/questions"><el-dropdown-item>我关注的问题</el-dropdown-item></router-link>
                                <router-link to="/MyHomePage/collections"> <el-dropdown-item>我关注的收藏</el-dropdown-item></router-link>
                            </el-dropdown-menu>
                            </el-dropdown>
                        </div>
                    </span>
                </div>
            </h4>
        </div>

        <!-- <topics></topics> -->
        <router-view></router-view>
    </div>
</div>
</template>

<script>
export default {
// import引入的组件需要注入到对象中才能使用
  components: {
  },
  data () {
    // 这里存放数据
    return {

    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {

  }
}
</script>

<style  scoped>
.List-header {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: justify;
    -ms-flex-pack: justify;
    justify-content: space-between;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    height: 50px;
    margin: 0 20px;
    border-bottom: 1px solid #f6f6f6;
    border-top: 1px solid #f6f6f6;
    -webkit-box-sizing: border-box;
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
    font-weight: normal;
}
.SubTabs {
    display: inline-block;
}
.SubTabs-item {
    height: 21px;
    padding: 6px 0 7px;
    margin-right: 36px;
}

a {
    color: inherit;
    text-decoration: none;
}
.Popover {
    position: relative;
    display: inline-block;
}
.Profile-mainColumn .SubTabs-item .Select-button {
    color: inherit;
}
.SubTabs .Select-button {
    font-size: 1em;
    font-weight: inherit;
}
.Select-button {
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    height: 40px;
    padding: 0 20px;
    line-height: 38px;
    text-align: left;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    background: none;
}
.Select-plainButton {
    padding: 0;
    border: 1px solid transparent;
}.Button--link, .Button--plain {
    border-radius: 0;
}
</style>
