<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <button @click="test">12312321</button>
    <el-button type="primary">主要按钮</el-button>
  </div>
</template>

<script>
import { reqLogin } from '../api/login.js'
import { ERR_OK } from '../api/config.js'
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  methods: {
    test () {
      console.log('2222')
      let params = {
        loginType: 2
      }
      reqLogin(params).then(res => {
        console.info(res)
        if (res.resultCode === ERR_OK) {
          console.log('success')
          console.log('data', res)
        } else {
          console.log('error')
        }
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang='scss'>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
