<template>
<div class='Profile-sideColumn'>
    <!-- 个人成就栏 -->
    <div class="Card">
        <div class="Card-header Profile-sideColumnTitle">
            <div class="Card-headerText">个人成就</div>
        </div>
        <div class="Profile-sideColumnItems">
            <div class="Profile-sideColumnItem">
                <div class="IconGraf">
                    <i class="el-icon-thumb IconGraf-iconWrapper"></i> 获得 {{userInfo.agreed}} 次赞同
                </div>
                <div class="Profile-sideColumnItemValue">
                </div>
            </div>
        </div>
    </div>

    <!-- 关注情况栏 -->
    <div class="Card FollowshipCard">
        <div class="NumberBoard FollowshipCard-counts NumberBoard--dividerNumberBoard FollowshipCard-counts NumberBoard--divider">
            <a type="button" class="Button NumberBoard-item Button--plain" href="">
                <div class="NumberBoard-itemInner">
                    <div class="NumberBoard-itemName">关注了</div>
                    <strong class="NumberBoard-itemValue" title="2">{{userInfo.followling}}</strong>
                </div>
            </a>
            <a type="button" class="Button NumberBoard-item Button--plain" href="">
                <div class="NumberBoard-itemInner">
                    <div class="NumberBoard-itemName">关注者</div>
                    <strong class="NumberBoard-itemValue" title="0">{{userInfo.followed}}</strong>
                </div>
            </a>
        </div>
    </div>

    <!-- 列表 -->
    <div class="Profile-lightList">
        <a class="Profile-lightItem" href="">
            <span class="Profile-lightItemName">关注的话题</span>
            <span class="Profile-lightItemValue">{{userInfo.Ftopic}}</span>
        </a>
        <a class="Profile-lightItem" href="">
            <span class="Profile-lightItemName">关注的专栏</span>
            <span class="Profile-lightItemValue">{{userInfo.Fcloumn}}</span>
        </a>
        <a class="Profile-lightItem" href="">
            <span class="Profile-lightItemName">关注的问题</span>
            <span class="Profile-lightItemValue">{{userInfo.Fquestion}}</span>
        </a>
        <a class="Profile-lightItem" href="">
            <span class="Profile-lightItemName">关注的收藏夹</span>
            <span class="Profile-lightItemValue">{{userInfo.Fcollect}}</span>
        </a>
    </div>

    <div class="Profile-footerOperations"></div>
    <sidefooter></sidefooter>
</div>
</template>

<script>
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
import sidefooter from '../../test2/components/right/aboutZhihu/other_fence.vue'
export default {
// import引入的组件需要注入到对象中才能使用
  components: {
    'sidefooter': sidefooter
  },
  data () {
    // 这里存放数据
    return {
      userInfo: {
        agreed: sessionStorage.getItem('praiseNum'),
        followling: sessionStorage.getItem('attentNum'),
        followed: sessionStorage.getItem('followNum'),
        Ftopic: sessionStorage.getItem('topicNum'),
        Fcloumn: 0,
        Fquestion: 0,
        Fcollect: 0
      }
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
div{
    display: block;
}
.Profile-sideColumn {
    width: 296px;
    color: #646464;
}
.Card {
    margin-bottom: 10px;
    background: #fff;
    overflow: hidden;
    border-radius: 2px;
    -webkit-box-shadow: 0 1px 3px rgba(26,26,26,.1);
    box-shadow: 0 1px 3px rgba(26,26,26,.1);
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.Card-header {
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
    padding: 0 20px;
    border-bottom: 1px solid #f6f6f6;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.Card-headerText {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    font-weight: 600;
}
.Profile-sideColumnItems {
    padding: 12px 0;
}
.Profile-sideColumnItem {
    padding: 6px 20px;
}
.IconGraf {
    display: flex;
    margin-bottom: 12px;
}
.IconGraf-iconWrapper {
    display: inline-flex;
    -webkit-box-align: center;
    align-items: center;
    width: 28px;
}
.Profile-sideColumnItemValue {
    margin-top: 6px;
    margin-left: 29px;
    font-size: 14px;
    color: #8590a6;
}
.FollowshipCard {
    font-size: 14px;
}
.NumberBoard {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
}
.NumberBoard-item.Button {
    border: 0;
    line-height: unset;
    font-size: unset;
}
.NumberBoard-item {
    -webkit-box-flex: 1;
    -ms-flex: 1 1;
    flex: 1 1;
}
.Button--plain {
    height: auto;
    padding: 0;
    line-height: inherit;
    background-color: transparent;
    border: none;
    border-radius: 0;
}
.FollowshipCard .NumberBoard-itemInner {
    padding: 12px 0;
}
.NumberBoard-itemInner {
    text-align: center;
    line-height: 1.6;
}
.NumberBoard-itemName {
    font-size: 14px;
    color: #8590a6;
}
.NumberBoard-itemValue {
    display: inline-block;
    font-size: 18px;
    color: #1a1a1a;
    font-weight: 600;
    font-synthesis: style;
}
a {
    text-decoration: none;
}

.Profile-lightList {
    font-size: 14px;
}
.Profile-lightItem {
    padding-left: 5px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    height: 46px;
    font-size: 14px;
    border-top: 1px solid #ebebeb;
}
.Profile-lightItemName {
    -webkit-box-flex: 1;
    flex-grow: 1;
}
.Profile-lightItemValue {
    font-size: 14px;
    color: #8590a6;
}
</style>
