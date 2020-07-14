<template>
  <div>
    <el-row style="background-color: rgba(26,26,26,0)">
      <el-col :span="5">
        <div class="bg-purple"><a href="http://localhost:8080/#/Home/index/contentBox"
                                  style="text-decoration: none;color: #409EFF">知乎</a></div>
      </el-col>
      <el-col :span="4">
        <div>
          <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
            <el-menu-item class="nav-item" index="/Home/index">首页</el-menu-item>
            <el-menu-item class="nav-item" index="2">发现</el-menu-item>
            <el-menu-item class="nav-item" index="3">问题</el-menu-item>
          </el-menu>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="nav-level">
          <el-input
            placeholder="请输入内容"
            suffix-icon="el-icon-search">
          </el-input>
          <el-button type="primary" size="mini" class="button-margin" @click="dialogVisible = true"
                     style="background-color: #0077e6">提问
          </el-button>

          <!--提问-->
          <div>
            <el-dialog :visible.sync="dialogVisible" center style="width: 80%">
              <div>
                <div id="askHeader" style="margin-top: -30px">
                  <!--头像-->
                  <el-avatar v-if="checkbox===true" shape="square" :size="50" :src="photo1"/>
                  <el-avatar v-if="checkbox===false" shape="square" :size="50" :src="photo"/>
                  <!---->
                  <el-input style=";margin-left: 20px;width: 80%"
                            maxl
                            type="textarea"
                            rows="2"
                            placeholder="写下你的问题，准确的描述问题更容易得到解答"
                            v-model="topic">
                  </el-input>

                  <div id="wrapper" style="margin-left: 72%;margin-top: 10px">
                    <el-button size="mini" style="width: 30px;height: 30px"><span class="el-icon-edit"
                                                                                  style="margin-left: -5px"></span>
                    </el-button>
                    <el-button size="mini" style="width: 30px;height: 30px"><span class="el-icon-picture"
                                                                                  style="margin-left: -5px"></span>
                    </el-button>
                    <el-button size="mini" style="width: 30px;height: 30px"><span class="el-icon-video-camera"
                                                                                  style="margin-left: -5px"></span>
                    </el-button>
                  </div>
                </div>
                <!--富文本框-->
                <div class="edit_container">
                  <quill-editor
                    v-model="content"
                    ref="myQuillEditor"
                    :options="editorOption"
                    @blur="onEditorBlur($event)" @focus="onEditorFocus($event)"
                    @change="onEditorChange($event)">
                  </quill-editor>
                </div>
                <!--添加话题-->
                <div id="topic" style="margin-top: 5px">
                  <el-tag
                    style="color: #409EFF;"
                    :key="tag"
                    v-for="tag in dynamicTags"
                    closable
                    :disable-transitions="false"
                    @close="handleClose(tag)"
                    v-model="dynamicTags">
                    {{tag}}
                  </el-tag>
                  <span v-show="number<5">
                    <el-autocomplete
                      style="width: 20%"
                      class="input-new-tag"
                      v-if="inputVisible"
                      ref="saveTagInput"
                      size="small"
                      @keyup.enter.native="handleInputConfirm"
                      popper-class="my-autocomplete"
                      v-model="inputValue"
                      :fetch-suggestions="querySearch"
                      placeholder="请输入内容"
                      @select="handleSelect">
                    <template slot-scope="{ item }">
                      <div class="name">{{ item.value}}</div>
                    </template>
                  </el-autocomplete>
                      <el-button v-else class="button-new-tag" size="small" @click="showInput"><span
                        style="color:#409EFF;margin-left: 10px" v-if="number===0">
                        ＋添加话题(至少一个话题)
                      </span><span v-else style="color:#0077e6;"><b>+</b>添加话题(<span>{{number}}/5</span>)</span></el-button>
                  </span>

                </div>
                <!--提问框底部-->
                <div slot="footer" style="margin-top: 10px">
                  <el-checkbox v-model="checkbox" true-value="0"
                               false-value="1">匿名提问
                  </el-checkbox>
                  <el-button type="primary" size="small" @click="submitQues"
                             style="margin-left: 300px;background-color: #409EFF;">发布问题
                  </el-button>
                </div>
              </div>
            </el-dialog>
          </div>
        </div>

      </el-col>
      <el-col :span="5">
        <div class="nav-level">
          <div class="nav-item" style="margin:0 0 0 40px"><i class="el-icon-message-solid icon-size"></i></div>
          <div class="nav-item"><i class="el-icon-s-marketing icon-size"></i></div>
          <div class="nav-item">
            <el-dropdown trigger="click">
              <span class="el-dropdown-link">
                <img :src="imagUrl" width="25px" height="25px" class="icon-size">
                <span>{{name}}</span>
              </span>
              <el-dropdown-menu slot="dropdown">
                <router-link to="/MyHomePage/activity">
                  <el-dropdown-item icon="el-icon-user-solid">我的主页</el-dropdown-item>
                </router-link>
                <el-dropdown-item icon="el-icon-s-tools">设置</el-dropdown-item>
                <el-dropdown-item icon="el-icon-switch-button">
                  <el-button type="text" @click="exit" style="color: #606266">退出</el-button>
                </el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-container class="main">
      <router-view/>
    </el-container>
  </div>
</template>
<script>
import { askQuestion } from '../api/askQuestion'
import { getAllTopic } from '../api/home'

export default {
  data () {
    return {
      imagUrl: sessionStorage.getItem('imagUrl'),
      number: 0,
      activeIndex: '',
      restaurants: [],
      state: '',
      dialogVisible: false,
      photo: sessionStorage.getItem('imagUrl'),
      photo1: 'https://pic1.zhimg.com/da8e974dc_xs.jpg',
      // 提问
      checkbox: false,
      topic: '',
      content: '',
      dynamicTags: [],
      editorOption: {
        modules: {
          toolbar: [
            ['bold', 'italic', 'underline', 'strike'], // 加粗，斜体，下划线，删除线
            ['blockquote', 'code-block'], // 引用，代码块
            ['clean'], // 清除字体样式
            ['image', 'video']// 传图片、上传视频
          ]
        },
        theme: 'snow'
      },
      name: sessionStorage.getItem('user'),
      userId: '',
      // 话题标签
      inputVisible: false,
      inputValue: ''
    }
  },
  computed: {
    editor () {
      return this.$ref.myQuillEditor.quill
    }
  },
  methods: {
    submitQues () {
      this.checkValue = this.checkbox ? 1 : 0
      if (this.topic === '' || this.content === '') {
        alert('请输入完整的信息')
        return false
      } else {
        this.topic = this.topic.endsWith('?') ? this.topic : this.topic + '?'
        let params = {
          userId: this.userId,
          ques_name: this.topic,
          quesDescribe: this.content,
          anonymity: this.checkValue,
          topicName: this.dynamicTags
        }
        this.dialogVisible = false
        askQuestion(params).then(res => {
          console.log(res)
          if (res.resultMessage === '标题包含敏感词汇') {
            alert('标题包含敏感词汇,请更改信息' + res.data.str)
          }
          if (res.resultMessage === '话题包含敏感词汇') {
            alert('话题包含敏感词汇,请更改信息' + res.data.str)
          }
          if (res.resultMessage === '内容包含敏感词汇') {
            alert('内容包含敏感词汇,请更改信息' + res.data.str)
          }
          if (res.resultMessage === '内容标题都包含敏感词汇') {
            alert('内容包含敏感词汇,请更改信息' + res.data.str)
          }
          this.$router.push({
            name: 'Home'
          })
        })
      }
    },
    onEditorReady (editor) { // 准备编辑器
    },
    onEditorBlur () {
    }, // 失去焦点事件
    onEditorFocus () {
    }, // 获得焦点事件
    onEditorChange () {
    }, // 内容改变事件

    // 标签方法
    handleClose (tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1)
      this.number--
    },

    showInput () {
      this.inputVisible = true
      this.$nextTick(_ => {
        this.$ref.saveTagInput.$ref.input.focus()
      })
    },

    handleInputConfirm () {
      let inputValue = this.inputValue
      if (inputValue) {
        this.dynamicTags.push(inputValue)
        this.number++
      }
      this.inputVisible = false
      this.inputValue = ''
    },
    exit () {
      sessionStorage.clear()
      this.$router.push({ 'path': '/Login' })
    },
    querySearch (queryString, cb) {
      this.restaurants = []
      getAllTopic().then(res => {
        for (var i = 0; i < res.data.length; i++) {
          this.restaurants.push({ 'value': res.data[i].topic_name })
        }
        console.log('循环数据', this.restaurants)
        var results = queryString ? this.restaurants.filter(this.createFilter(queryString)) : this.restaurants
        cb(results)
      })

      // 调用 callback 返回建议列表的数据
    },
    createFilter (queryString) {
      return (restaurant) => {
        return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0)
      }
    },
    loadAll () {
      return this.restaurants
    },
    handleSelect (item) {
      this.$ref.saveTagInput.$ref.input.focus()
    }
  },
  mounted () {
    this.restaurants = this.loadAll()
  },
  beforeMount () {
    this.userId = sessionStorage.getItem('userId')
    console.log(this.userId)
  }
}

</script>
<style lang='scss'>
  .el-tag + .el-tag {
    margin-left: 10px;
  }

  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }

  .input-new-tag {
    width: 90px;
    margin-left: -10px;
    vertical-align: bottom;
  }

  .edit_container {
    height: 100%;
    width: 95%;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 10px;
  }

  .el-row {
    height: 10px;

    &:last-child {
      margin-bottom: 0;
    }

    .el-col {
      border-radius: 4px;
      height: 45px;

      .nav-level {
        display: flex;
        padding: 0 0 0 10px;
      }

      .nav-item-one {
        width: 40px;
        height: 40px;
        line-height: 40px;
        margin: 0px 10px 0 15px;
        font-weight: bold;
        text-align: center;
      }

      .nav-item {
        width: 50px;
        height: 40px;
        line-height: 40px;
        text-align: center;
        padding: 0px 40px 0 40px;
        font-weight: bold
      }

      .border-Line {
        border-bottom: 3px solid #33CCFF;
      }

      .bg-purple {
        float: right;
        font-size: 30px;
        color: #33CCFF;
      }

      .button-margin {
        margin: 0 15px 0 15px;
      }

      .icon-size {
        font-size: 25px;
      }
    }
  }

  .main {
    width: 100%;
    height: 40px;
  }

  a{text-decoration:none;}

  /* 话题下拉表 */
  .my-autocomplete {
    li {
      line-height: normal;
      padding: 7px;

      .name {
        text-overflow: ellipsis;
        overflow: hidden;
      }

      .addr {
        font-size: 12px;
        color: #b4b4b4;
      }

      .highlighted .addr {
        color: #ddd;
      }
    }
  }
</style>
