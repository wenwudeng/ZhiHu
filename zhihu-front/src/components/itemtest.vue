<!--  -->
<template>
  <div>
      <input @click="sendMsg" type="button" value="给父组件传值">
      <div>{{propstest}}</div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      msg: '我是子组件的msg'
    }
  },
  props: ['propstest'],

  components: {},

  computed: {},

  mounted: {},

  methods: {
    // func: 是父组件指定的传数据绑定的函数，this.msg:子组件给父组件传递的数据
    sendMsg () {
      this.$emit('func', this.msg)
    }
  }
}

</script>
<style scoped>
</style>
