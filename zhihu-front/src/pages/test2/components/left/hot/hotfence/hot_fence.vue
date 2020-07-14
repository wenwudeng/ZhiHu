<template>
  <div id="hot_fence">
    <div id="topic_bar">
      <div id="topic_content">
        <TopicBar v-for="(i, index) in titleList" :key="index" :list="i" @changeJudge="changeJudge"></TopicBar>
      </div>
      </div>
        <HotContent v-for="(i, index) in hotContentList" :key="index" :contentlist="i"></HotContent>
      </div>
</template>

<script>
import TopicBar from '../hotfence/topictitle/topicbar'
import HotContent from '../hotfence/hotcontent/hot_content'
import { getHotTopic, getHotQues } from '../../../../../../api/hot'

import { ERR_OK } from '../../../../../../api/config.js'
export default {
  name: 'hot_fence',
  components: {
    'TopicBar': TopicBar,
    'HotContent': HotContent
  },
  data () {
    return {
      titleList: [
        { 'title': '全站', 'judge': true }
      ],
      tempList: [
      ],
      hotContentList: [
      ]
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    changeJudge (data) {
      for (let i = 0; i < this.titleList.length; i++) {
        this.$set(this.titleList[i], 'judge', false)
        if (this.titleList[i].title === data) {
          this.$set(this.titleList[i], 'judge', true)
          let params = 'name=' + this.titleList[i].title
          console.log(params)
          getHotQues(params).then(res => {
            if (res.resultCode === ERR_OK) {
              this.hotContentList = res.data
              console.log(this.hotContentList)
            } else {
              console.log('error')
            }
          })
        }
      }
    },
    _loadData () {
      getHotTopic().then(res => {
        if (res.resultCode === ERR_OK) {
          this.tempList = res.data
          for (let j = 0; j < this.tempList.length; j++) {
            this.titleList.push({ 'title': this.tempList[j].topic, 'judge': false })
          }
          let params = 'name=' + this.titleList[0].title
          console.log(params)
          getHotQues(params).then(res => {
            if (res.resultCode === ERR_OK) {
              this.hotContentList = res.data
              console.log(this.hotContentList)
            } else {
              console.log('error')
            }
          })
        } else {
          console.log('error')
        }
      })
    }
  }
}

</script>

<style scoped>

#hot_fence {
  width: 695px;
  height: 180px;
  background-color: white
}
#topic_bar{
  width: 100%;
  height: 70px;
  background-color: white;
}
#topic_content{
  padding: 20px;
  width: 655px;
  height: 30px;
  background-color: white;

}
</style>
