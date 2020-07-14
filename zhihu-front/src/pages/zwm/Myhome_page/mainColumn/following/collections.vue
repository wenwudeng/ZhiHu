<!--  -->
<template>
<div >
    <div class="List-item" v-for="(item,index) in topicList" :key="index" >
        <div class="ContentItem">
            <div class="ContentItem-main">
                <div class="ContentItem-image">
                    <img class="Avatar Avatar--large" width="60" height="60" :src="item.avaPic_src">
                </div>
                <div class="ContentItem-head">
                    <h2 class="ContentItem-title">
                        <a class="TopicLink" href="" target="_blank">
                            <div class="Popover">{{item.name}}</div>
                        </a>
                    </h2>
                    <div class="ContentItem-meta">
                        <div class="ContentItem-status">
                            <a class="ContentItem-statusItem TopicItem-statusLink" href="">{{item.ansNum}}个回答</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</template>

<script>
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';

export default {
// import引入的组件需要注入到对象中才能使用
  components: {},
  data () {
    // 这里存放数据
    return {
      topicList: [
        { avaPic_src: 'https://pic3.zhimg.com/a541b01d4_im.jpg', name: '情感', ansNum: 2 },
        { avaPic_src: 'https://pic3.zhimg.com/5c5f5d55992d64aa8184b29c53e80af4_im.jpg', name: '职业发展', ansNum: 5 },
        { avaPic_src: 'https://pic3.zhimg.com/v2-78f4b42d0750ff5cecc0f6ec9453bc5f_im.jpg', name: '数据分析', ansNum: 0 }
      ]

    }
  },
  // 方法集合
  methods: {

  }
}
</script>

<style  scoped>
.List-item {
    position: relative;
    padding: 16px 20px;
}
div {
    display: block;
}
.ContentItem-main {
    display: flex;
}
.ContentItem-image {
    float: left;
    margin-right: 16px;
}
.Avatar {
    background: #fff;
    border-radius: 2px;
}.ContentItem-head {
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
h2 {
    margin: 0;
    font: inherit;
    display: block;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}
a {
    color: inherit;
    text-decoration: none;
}

.ContentItem-meta {
    font-size: 15px;
    color: #646464;
    margin-top: 6px;
}
.ContentItem-status {
    margin-top: 5px;
    color: #8590a6;
    font-size: 14px;
}
.TopicItem-statusLink {
    font-size: 14px;
    color: #175199;
}
</style>
