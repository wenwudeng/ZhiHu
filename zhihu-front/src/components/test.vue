<template>
  <div>
    <input v-model="inputValue"/>
    <button @click="handleClick">增加</button>
    <ul>
      <li v-for="(item, index) of list" :key='index'>{{item}}</li>
    </ul>
    <child @func="getMsgFormSon" :propstest="msgFormSon"></child>
    <div>{{msgFormSon}}</div>
    <input @click="test" type="button" value="测试">
  </div>
</template>

<script>
import child from './itemtest'
export default {
  data () {
    return {
      inputValue: '',
      show: true,
      list: [],
      msgFormSon: '父组件的msg'
    }
  },

  components: {
    child
  },

  computed: {},

  mounted: {},

  methods: {
    handleClick () {
      this.list.push(this.inputValue)
      this.inputValue = ''
    },
    getMsgFormSon (data) {
      this.msgFormSon = data
    },
    test () {
      this.msgFormSon = '22222222222222222'
    }
  }
}

</script>
<style scoped>
</style>
