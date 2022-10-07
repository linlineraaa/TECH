const menu = {
  list() {
    return [{
      "backMenu": [{
        "child": [{
          "buttons": ["New", "view", "Modify", "Delete"],
          "menu": "Course Category Management",
          "menuJump": "List",
          "tableName": "kechengfenlei"
        }], "menu": "Course Category Management"
      }, {
        "child": [{
          "buttons": ["New", "view", "Modify", "Delete", "View Comments"],
          "menu": "Course",
          "menuJump": "List",
          "tableName": "zaixianxuexi"
        }], "menu": "Course Management"
      }, {
        "child": [{
          "buttons": ["New", "view", "Modify", "Delete"],
          "menu": "Quiz List",
          "tableName": "exampaperlist"
        }, {
          "buttons": ["New", "view", "Modify", "Delete"],
          "menu": "Quiz records",
          "tableName": "examrecord"
        }, {
          "buttons": ["view"],
          "menu": "Wrong question",
          "tableName": "examfailrecord"
        }, {"buttons": ["New", "view", "Modify", "Delete"], "menu": "Quiz Management", "tableName": "exampaper"}],
        "menu": "Quiz Management"
      }, {
        "child": [{
          "buttons": ["New", "view", "Modify", "Delete"],
          "menu": "Questions Management",
          "tableName": "examquestion"
        }], "menu": "Questions Management"
      }, {
        "child": [{"buttons": ["New", "view", "Modify", "Delete"], "menu": "System Forum", "tableName": "forum"}],
        "menu": "System Forum"
      }, {
        "child": [{
          "buttons": ["New", "view", "Modify", "Delete"],
          "menu": "News Management",
          "tableName": "news"
        },
          {
            "buttons": ["New", "view", "Modify", "Delete"],
            "menu": "Online Q&A",
            "tableName": "chat"
          },
        ], "menu": "System Management"
      }],
      "frontMenu": [{
        "child": [{
          "buttons": ["view"],
          "menu": "Course List",
          "menuJump": "List",
          "tableName": "zaixianxuexi"
        }], "menu": "Course Modules"
      }],
      "hasBackLogin": "yes",
      "hasBackRegister": "no",
      "hasFrontLogin": "no",
      "hasFrontRegister": "no",
      "roleName": "Teacher",
      "tableName": "users"
    }, {
      "backMenu": [{
        "child": [{
          "buttons": ["Delete", "Modify", "view"],
          "menu": "Collection Management",
          "tableName": "storeup"
        }], "menu": "Collection Management"
      }, {
        "child": [{
          "buttons": ["view", "Delete"],
          "menu": "Quiz records",
          "tableName": "examrecord"
        }, {
          "buttons": ["view", "Delete"],
          "menu": "Wrong question",
          "tableName": "examfailrecord"
        }, {"buttons": ["view"], "menu": "Quiz List", "tableName": "exampaperlist"}], "menu": "" +
          "" +
          "" +
          "Quiz Management"
      }],
      "frontMenu": [{
        "child": [{
          "buttons": ["view"],
          "menu": "CourseList",
          "menuJump": "List",
          "tableName": "zaixianxuexi"
        }], "menu": "CourseModule"
      }],
      "hasBackLogin": "yes",
      "hasBackRegister": "yes",
      "hasFrontLogin": "yes",
      "hasFrontRegister": "yes",
      "roleName": "Student",
      "tableName": "yonghu"
    }]
  }
}
export default menu;
