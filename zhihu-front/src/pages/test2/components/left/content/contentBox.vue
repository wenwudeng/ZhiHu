<template>
  <div id="content_box">
      <ContentFence v-for="(i, index) in contentList" :key="index" :list="i"></ContentFence>
  </div>
</template>

<script>
import ContentFence from '../content/contentfence/content_fence'
import { getAllQues } from '../../../../../api/home'
import { ERR_OK } from '../../../../../api/config.js'
export default {
  name: 'content_box',
  components: {
    'ContentFence': ContentFence
  },
  data () {
    return {
      contentList: [
      ]
    }
  },
  created () {
    this._loadData()
  },
  methods: {
    _loadData () {
      let params = 'userId=' + sessionStorage.getItem('userId')
      getAllQues(params).then(res => {
        if (res.resultCode === ERR_OK) {
          this.contentList = res.data
          console.log(this.contentList)
        } else {
          console.log('error')
        }
      })
    }
  }
}

</script>

<style scoped>
#content_box{
  height: 100px;
  width: 100%;
}
</style>
