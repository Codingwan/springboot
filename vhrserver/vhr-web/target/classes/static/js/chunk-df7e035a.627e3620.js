(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-df7e035a"],{1937:function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div")},i=[],n={name:"SalSearch"},s=n,r=e("2877"),c=Object(r["a"])(s,l,i,!1,null,"02efe3c8",null);a["default"]=c.exports},"21c7":function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div")},i=[],n={name:"SalTable"},s=n,r=e("2877"),c=Object(r["a"])(s,l,i,!1,null,"a9f381d4",null);a["default"]=c.exports},"2bc5":function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("div",[e("el-button",{attrs:{icon:"el-icon-plus"},on:{click:t.showAddSalary}},[t._v("添加工资账套")]),e("el-dialog",{attrs:{title:t.dialogTitle,visible:t.dialogVisible,width:"50%"},on:{"update:visible":function(a){t.dialogVisible=a}}},[e("div",{staticStyle:{display:"flex","justify-content":"space-around","align-items":"center"}},[e("el-steps",{attrs:{direction:"vertical",active:t.active}},t._l(t.salaryItemName,(function(t,a){return e("el-step",{key:a,attrs:{title:t}})})),1),t._l(t.salary,(function(a,l,i){return e("el-input",{directives:[{name:"show",rawName:"v-show",value:t.active==i,expression:"active==index"}],key:i,staticStyle:{width:"200px"},attrs:{placeholder:"请输入"+t.salaryItemName[i]+"..."},model:{value:t.salary[l],callback:function(a){t.$set(t.salary,l,a)},expression:"salary[title]"}})}))],2),e("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:t.preStep}},[t._v(t._s(0==t.active?"取消":"上一步"))]),e("el-button",{attrs:{type:"primary"},on:{click:t.nextStep}},[t._v(t._s(9==t.active?"完成":"下一步"))])],1)]),e("el-button",{attrs:{icon:"el-icon-refresh"}})],1),e("div",[e("el-table",{attrs:{data:t.salaries,border:"",stripe:""}},[e("el-table-column",{attrs:{type:"selection",width:"30"}}),e("el-table-column",{attrs:{width:"120",prop:"name",label:"账套名称"}}),e("el-table-column",{attrs:{width:"70",prop:"basicsalary",label:"基本工资"}}),e("el-table-column",{attrs:{width:"70",prop:"trafficsalary",label:"交通补助"}}),e("el-table-column",{attrs:{width:"70",prop:"lunchsalary",label:"午餐补助"}}),e("el-table-column",{attrs:{width:"70",prop:"bonus",label:"奖金"}}),e("el-table-column",{attrs:{width:"70",prop:"createdate",label:"启用时间"}}),e("el-table-column",{attrs:{align:"center",label:"医疗保险"}},[e("el-table-column",{attrs:{width:"70",prop:"medicalper",label:"比率"}}),e("el-table-column",{attrs:{width:"70",prop:"medicalbase",label:"基数"}})],1),e("el-table-column",{attrs:{align:"center",label:"养老金"}},[e("el-table-column",{attrs:{width:"70",prop:"pensionper",label:"比率"}}),e("el-table-column",{attrs:{width:"70",prop:"pensionbase",label:"基数"}})],1),e("el-table-column",{attrs:{align:"center",label:"公积金"}},[e("el-table-column",{attrs:{width:"70",prop:"accumulationfundper",label:"比率"}}),e("el-table-column",{attrs:{width:"70",prop:"accumulationfundbase",label:"基数"}})],1),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(a){return[e("el-button",{on:{click:function(e){return t.showEditSalaryView(a.row)}}},[t._v("编辑")]),e("el-button",{attrs:{type:"danger"},on:{click:function(e){return t.deleteSalary(a.row)}}},[t._v("删除")])]}}])})],1)],1)])},i=[],n=(e("b0c0"),{name:"SalSob",data:function(){return{salaries:[],dialogVisible:!1,dialogTitle:"添加工资账套",active:0,salaryItemName:["基本工资","交通补助","午餐补助","奖金","养老金比率","养老金基数","医疗保险比率","医疗保险基数","公积金比率","公积金基数","账套名称"],salary:{basicsalary:0,trafficsalary:0,lunchsalary:0,bonus:0,pensionper:0,pensionbase:0,medicalper:0,medicalbase:0,accumulationfundper:0,accumulationfundbase:0,name:""}}},mounted:function(){this.initSalaries()},methods:{showEditSalaryView:function(t){this.dialogTitle="修改工资账套",this.salary.basicsalary=t.basicsalary,this.salary.lunchsalary=t.lunchsalary,this.salary.trafficsalary=t.trafficsalary,this.salary.pensionbase=t.pensionbase,this.salary.pensionper=t.pensionper,this.salary.accumulationfundbase=t.accumulationfundbase,this.salary.accumulationfundper=t.accumulationfundper,this.salary.bonus=t.bonus,this.salary.name=t.name,this.salary.medicalbase=t.medicalbase,this.salary.medicalper=t.medicalper,this.salary.id=t.id,this.dialogVisible=!0},deleteSalary:function(t){var a=this;this.$confirm("此操作将会删除，请确认是否继续！","提示",{cancelButtonText:"取消",confirmButtonText:"确定"}).then((function(){a.deleteRequest("/salary/sob/"+t.id).then((function(t){t&&a.initSalaries()}))})).catch((function(){a.$message.info("取消删除")}))},preStep:function(){0!=this.active?this.active--:alert("我来了")},nextStep:function(){var t=this;10!=this.active?this.active++:this.salary.id?this.putRequest("/salary/sob/",this.salary).then((function(a){a&&(t.initSalaries(),t.dialogVisible=!1)})):this.postRequest("/salary/sob/",this.salary).then((function(a){a&&(t.initSalaries(),t.dialogVisible=!1)}))},showAddSalary:function(){this.dialogTitle="添加工资账套",this.dialogVisible=!0},initSalaries:function(){var t=this;this.getRequest("/salary/sob/").then((function(a){a&&(t.salaries=a)}))}}}),s=n,r=e("2877"),c=Object(r["a"])(s,l,i,!1,null,"6bc07597",null);a["default"]=c.exports},"6ac98":function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div")},i=[],n={name:"SalSobCfg"},s=n,r=e("2877"),c=Object(r["a"])(s,l,i,!1,null,"72bf3120",null);a["default"]=c.exports},d7e6:function(t,a,e){var l={"./SalMonth.vue":"fbac","./SalSearch.vue":"1937","./SalSob.vue":"2bc5","./SalSobCfg.vue":"6ac98","./SalTable.vue":"21c7"};function i(t){var a=n(t);return e(a)}function n(t){if(!e.o(l,t)){var a=new Error("Cannot find module '"+t+"'");throw a.code="MODULE_NOT_FOUND",a}return l[t]}i.keys=function(){return Object.keys(l)},i.resolve=n,t.exports=i,i.id="d7e6"},fbac:function(t,a,e){"use strict";e.r(a);var l=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div")},i=[],n={name:"SalMonth"},s=n,r=e("2877"),c=Object(r["a"])(s,l,i,!1,null,"b1867c54",null);a["default"]=c.exports}}]);
//# sourceMappingURL=chunk-df7e035a.627e3620.js.map