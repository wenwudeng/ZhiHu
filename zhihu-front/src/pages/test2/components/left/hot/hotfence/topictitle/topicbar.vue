<template>
  <div id="topic_btn" @click="changeJudge" :style="list.judge?changeStyle:''">
    {{ list.title }}
  </div>
</template>

<script>
export default {
  data () {
    return {
      changeStyle: [{ 'color': '#0997F7' }]
    }
  },
  props: ['list'],
  methods: {
    changeJudge () {
      this.$emit('changeJudge', this.list.title)
    }
  }
}
</script>
<style scoped>
#topic_btn{
  vertical-align: top;
  display: inline-block;
  margin-left: 10px;
  cursor:pointer;
  width: 60px;
  height: 20px;
  background-color: #f6f6f6;
  color:#646464;
  padding: 5px;
  text-align:center;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
</style>
