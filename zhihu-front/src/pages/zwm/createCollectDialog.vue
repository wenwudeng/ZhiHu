<!-- 创建收藏夹弹窗-->
<template>
    <div class="Modal-inner">
      <el-dialog
        width="519px"
        :visible.sync="showC"
        :before-close="handleCloseCreate"
        :close-on-click-modal="false"
        center>
        <h3 class="Modal-title">创建新收藏夹</h3>
        <div class="Modal-content">
          <form class="Favlists-content">
            <div class="Favlists-addItems">
              <div class="Favlists-addItem">
                <div class="Favlists-titleInput Input-wrapper">
                  <input v-model="favoritesName" class="Input" placeholder="收藏标题">
                </div>
                <div class="Favlists-inputTips">
                  <span class="MaxLength"></span>
                </div>
              </div>

              <div class="Favlists-addItem">
                <div class="Favlists-descritionInput Input-wrapper Input-wrapper--multiline">
                  <textarea rows="5" v-model="favoritesDescribe" class="Input" placeholder="收藏描述（可选）"></textarea>
                </div>
                <div class="Favlists-inputTips"><span class="MaxLength"></span></div>
              </div>

              <div class="Favlists-addItem">
                <label class="Favlists-privacyOption">
                  <input class="Favlists-privacyOptionRadio" v-model="open" name="isPublic" type="radio" value="1" checked>
                  <span>公开</span>
                  <span class="Favlists-privacyOptionTips">有其他人关注此收藏夹时不可设置为私密</span>
                </label>
                <label class="Favlists-privacyOption" >
                  <input class="Favlists-privacyOptionRadio" v-model="open" name="isPublic" type="radio" value="0">
                  <span>私密</span>
                  <span class="Favlists-privacyOptionTips">只有你自己可以查看这个收藏夹</span>
                </label>
              </div>
            </div>
            <div class="ModalButtonGroup ModalButtonGroup--horizontal">
              <button type="button" class="Button" @click="closeCreateCollectDialog">返回</button>
              <button type="button" class="Button Button--primary Button--blue" @click="createFavorites">确认创建</button>
            </div>
          </form>
        </div>
      </el-dialog>
    </div>
</template>
<script>
import { setFavorites } from '../../api/attent.js'
export default {
  props: ['showC'],
  data () {
    return {
      testList: '',
      userId: sessionStorage.getItem('userId'),
      favoritesName: '',
      favoritesDescribe: '',
      open: ''
    }
  },
  methods: {
    handleCloseCreate: function () {
      this.$emit('closeC')
      this.$emit('updateFav')
    },
    closeCreateCollectDialog: function () {
      this.$emit('closeC')
      this.$emit('updateFav')
    },
    createFavorites: function () {
      let params = {
        userId: this.userId,
        favoritesName: this.favoritesName,
        favoritesDescribe: this.favoritesDescribe,
        open: this.open
      }
      setFavorites(params).then(res => {
        if (res.resultCode === 200) {
          this.testList = res.data
          console.log(this.testList)
          this.handleCloseCreate()
        }
      })
    }
  }

}
</script>

<style scoped>
  .Modal-inner {
    overflow: auto;
    background: #fff;
    border-radius: 2px;
}
.Modal-title {
    font-size: 24px;
    font-weight: 500;
    color: #1a1a1a;
    text-align: center;
}
.Modal-content {
    -webkit-box-flex: 1;
    flex: 1 1;
    padding: 0 24px 32px;
    margin-top: 24px;
    line-height: 1.7;
    opacity: 1;
}
form {
    display: block;
    margin-top: 0em;
}
.Favlists-addItem {
    margin-bottom: 8px;
}
.Favlists-titleInput {
    width: 100%;
    height: auto;
    padding: 8px 10px;
}
.Input-wrapper {
    position: relative;
    display: flex;
    font-size: 14px;
    background: #fff;
    border: 1px solid #ebebeb;
    border-radius: 3px;
    box-sizing: border-box;
    transition: background .2s,border .2s;
}
.Input {
    -webkit-box-flex: 1;
    flex: 1 1;
    padding: 0;
    overflow: hidden;
    font-family: inherit;
    font-size: inherit;
    font-weight: inherit;
    background: transparent;
    border: none;
    resize: none;
}
.Favlists-inputTips {
    padding-top: 8px;
    text-align: right;
}
.MaxLength {
    font-size: 14px;
    color: #8590a6;
}
.collect{
  border-color: #0084ff;
  color: #0084ff;
}
.Input-wrapper.Input-wrapper--multiline {
    height: inherit;
}
.Favlists-descritionInput, .Favlists-titleInput {
    width: 100%;
    padding: 8px 12px;
}
.Favlists-privacyOption {
    display: block;
    margin-bottom: 6px;
    overflow: auto;
    font-size: 14px;
}
.Favlists-privacyOptionRadio:checked {
    background-color: #0084ff;
    border-color: #0084ff;
}
.Favlists-privacyOptionRadio {
    display: inline-block;
    width: 14px;
    height: 14px;
    padding: 2px;
    margin: 0 4px 0 0;
    vertical-align: middle;
    border: 2px solid #ebebeb;
    border-radius: 50%;
    -webkit-transition: background-color,border-color .3s;
    transition: background-color,border-color .3s;
    background-clip: content-box;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}
.Favlists-privacyOptionTips {
    margin-left: 4px;
    color: #8590a6;
}
.ModalButtonGroup--horizontal {
    display: flex;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
    flex-direction: row;
    margin-top: 48px;
}
.ModalButtonGroup--horizontal .Button {
    -webkit-box-flex: 1;
    flex: 1 1;
}
.Button {
    display: inline-block;
    padding: 0 16px;
    font-size: 14px;
    line-height: 32px;
    color: #8590a6;
    text-align: center;
    cursor: pointer;
    background: none;
    border: 1px solid;
    border-radius: 3px;
}
.ModalButtonGroup--horizontal .Button+.Button {
    margin-left: 16px;
}
.ModalButtonGroup--horizontal .Button {
    -webkit-box-flex: 1;
    flex: 1 1;
}
.Button--primary.Button--blue {
    color: #fff;
    background-color: #0084ff;
}
.Button--blue {
    color: #0084ff;
    border-color: #0084ff;
}
</style>
