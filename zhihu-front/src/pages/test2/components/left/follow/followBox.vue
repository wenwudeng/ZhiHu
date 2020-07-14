<template>
  <div id="follow_box">
      <ContentFence v-for="(i, index) in tempList" :key="index" :list="i"></ContentFence>
  </div>
</template>

<script>
import ContentFence from '../content/contentfence/content_fence'
import { getAllQues } from '../../../../../api/home'
import { ERR_OK } from '../../../../../api/config.js'
export default {
  name: 'follow_box',
  components: {
    'ContentFence': ContentFence
  },
  data () {
    return {
      contentList: [
      ],
      tempList: [
      ]
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      getAllQues().then(res => {
        if (res.resultCode === ERR_OK) {
          this.contentList = res.data
          this.tempList = this.contentList.quesList
          console.log(this.tempList)
        } else {
          console.log('error')
        }
      })
    }
  }
}

</script>

<style scoped>
#follow_box{
  height: 100px;
  width: 100%;
}
</style>
