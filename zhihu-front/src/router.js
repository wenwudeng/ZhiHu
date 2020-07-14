import Vue from 'vue'
import Router from 'vue-router'
import test from '@/components/test.vue'
import Home from '@/components/Home.vue'
import Login from './pages/entry/login'
import Register from './pages/entry/register'
import ContentBox from './pages/test2/components/left/content/contentBox'
import HotBox from './pages/test2/components/left/hot/hotBox'
import writeArticle from './pages/zwm/WriteArticle.vue'
import Question from './pages/question/Question'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/Login'
    },
    {
      path: '/Register',
      name: 'Register',
      component: Register
    },
    {
      path: '/Question',
      name: 'Question',
      component: Question,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/test',
      name: 'test',
      component: test,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/Home/test',
          menName: 'test',
          component: () => import('./components/test.vue'),
          meta: {
            requireAuth: true
          }
        },
        {
          path: '/Home/index',
          menName: 'index',
          component: () => import('./pages/test2/components/index.vue'),
          children: [
            {
              path: '/Home/index/contentBox',
              name: 'ContentBox',
              component: ContentBox,
              meta: {
                requireAuth: true
              }
            },
            {
              path: '/Home/index/follow',
              name: 'follow',
              component: ContentBox,
              meta: {
                requireAuth: true
              }
            },
            {
              path: '/Home/index/hot',
              name: 'hot',
              component: HotBox,
              meta: {
                requireAuth: true
              }
            }
          ],
          redirect: '/Home/index/contentBox'
        }
      ],
      redirect: '/Home/index/contentBox'
    },
    {
      path: '/Home/index/writeArticle',
      name: 'writeArticle',
      component: writeArticle,
      meta: {
        requireAuth: true
      }
    },
    {
      // 编辑页
      path: '/edit',
      name: 'edit',
      component: resolve => require(['./pages/zwm/edit.vue'], resolve),
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/MyHomePage',
      component: resolve => require(['./pages/zwm/MyHomePage.vue'], resolve),
      name: 'MyHomePage',
      meta: {
        requireAuth: true
      },
      children: [
        {
          // 动态页
          path: '/MyHomePage/activity',
          component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/dynamic.vue'], resolve),
          meta: {
            requireAuth: true
          }
        },
        {
          // 回答页
          path: '/MyHomePage/answer',
          component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/answer.vue'], resolve),
          meta: {
            requireAuth: true
          }
        },
        {
          // 提问页
          path: '/MyHomePage/askQuesttion',
          component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/askQuesttion.vue'], resolve),
          meta: {
            requireAuth: true
          }
        },
        {
          // 文章页
          path: '/MyHomePage/article',
          component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/article.vue'], resolve),
          meta: {
            requireAuth: true
          }
        },
        {
          // 专栏页
          path: '/MyHomePage/columns',
          component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/columns.vue'], resolve),
          meta: {
            requireAuth: true
          }
        },
        {
          // 想法页
          path: '/MyHomePage/pins',
          component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/pins.vue'], resolve),
          meta: {
            requireAuth: true
          }
        },
        {
          // 关注栏
          path: '/MyHomePage/follow',
          name: '/MyHomePage',
          component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/focusOn.vue'], resolve),
          meta: {
            requireAuth: true
          },
          children: [
            {
              // 我关注的人
              path: '/MyHomePage/following',
              component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/following/following.vue'], resolve),
              meta: {
                requireAuth: true
              }
            },
            {
              // 关注我的人
              path: '/MyHomePage/followers',
              component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/following/followers.vue'], resolve),
              meta: {
                requireAuth: true
              }
            },
            {
              // 我关注的话题
              path: '/MyHomePage/topics',
              component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/following/topics.vue'], resolve),
              meta: {
                requireAuth: true
              }
            },
            {
              // 我关注的问题
              path: '/MyHomePage/questions',
              component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/following/questions.vue'], resolve),
              meta: {
                requireAuth: true
              }
            },
            {
              // 我关注的收藏
              path: '/MyHomePage/collections',
              component: resolve => require(['./pages/zwm/Myhome_page/mainColumn/following/collections.vue'], resolve),
              meta: {
                requireAuth: true
              }
            }
          ]
        }
      ]
    }
  ]
})
