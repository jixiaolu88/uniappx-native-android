
// 在iframe内部执行以下代码
var iframeId = window.frameElement.getAttribute('id');
// 或者使用简写形式（两者等价）
var iframeId = this.frameElement.id;
// 等待初始化完毕
document.addEventListener('UniAppJSBridgeReady', () => {
	window.parent.postMessage({ action: 'onJSBridgeReady', data: '',iframeId:iframeId}, '*');
	uni.postMessage({
		data: {
			action: 'onJSBridgeReady'
		}
	})
	
})

// window.addEventListener('message', function(event) {

//   // 根据消息内容执行相应的操作或调用函数
//   if (typeof event.data === 'object' && event.data.action === 'callFunctionInIframe') {
//     var data = event.data.data;
//     myFunctionInIframe(data);
//   }
// });


var qr = null
// 绘制二维码。
function createQrcode(size, foreground, background,text,logo,logoSize) {
	// let width = window.frameElement.offsetWidth
	// let height = window.frameElement.offsetHeight
	var canvas = document.getElementById("qrcode")
	// canvas.width=width
	// canvas.height=height
	// canvas.style.width=width+'px'
	// canvas.style.height=height+'px'
	canvas.style.display="block"
	let ctx = canvas.getContext("2d");
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	document.body.style.overflow = "hidden"
	document.body.style.height = "100%"
	
	qr = new QRious({
		element: canvas,
		size: size||128,
		background: background||"white",
		backgroundAlpha: 1,
		foreground: foreground||"black",
		foregroundAlpha: 1,
		level: 'H',
		padding: null,
		value: text||'xui',
	});
	if(logo){
		let ctx = canvas.getContext("2d");
		let img = new Image();
		logoSize = logoSize||50
		img.width = logoSize+"px"
		img.height = logoSize+"px"
		img.src = logo
		img.onload = function(){
			let x = (size - logoSize) / 2
			let y = x;
			ctx.drawImage(img,x,y,logoSize,logoSize)
		}
	}
	
}
//获取二维码图片。
function QrcodeToDateUrl(){
	if(qr){
		let imgdata = qr.toDataURL();
		uni.postMessage({
			data: {
				action: 'img',
				url:imgdata
			}
		})
	}else{
		uni.postMessage({
			data: {
				action: 'error',
			}
		})
	}
}


var ect = null;
function getchart(){
	if(ect) return ect;
	let dom = document.getElementById('echart');
	return  echarts.init(dom);
}
function chart_setSize(){
	let width = window.innerWidth
	let height = window.innerHeight
	let dom = document.getElementById('echart');
	let domhtml = document.getElement
	dom.style.width = width+'px'
	dom.style.height = height+'px'
	document.getElementsByTagName('html')[0].style='overflow:hidden'
}
// 解码 JSON 字符串（包括深层解码）
function decodeJSON(jsonString) {
  return JSON.parse(jsonString, function(key, value) {
    if (typeof value === 'string' && /^function/.test(value)) {
      return eval('(' + value + ')'); // 将字符串形式的函数转换回函数类型
    }
    if (typeof value === 'object' && value !== null) {
      return decodeJSON(value); // 递归处理嵌套对象
    }
    return value;
  });
}

function chart_setOption(optionStr){
	chart_setSize()
	// 基于准备好的dom，初始化echarts实例
	let chart = getchart();
	if(!optionStr) return;
	let option = JSON.parse(optionStr)
	chart.setOption(option)
}
function chart_call(funName,optionStr,eventsid){
	
	chart_setSize()
	let filterevents = ["click"]
	// 基于准备好的dom，初始化echarts实例
	let chart = getchart();
	
	if(filterevents.includes(funName)){
		
		chart['on'](funName,function (params) {
			delete params.event
			window.parent.postMessage({ action: funName,eventId:eventsid, data: JSON.stringify(params),iframeId:iframeId}, '*');
			
			uni.postMessage({
				data: {
					action: funName,
					eventId:eventsid,
					data: JSON.stringify(params)
				}
			})
			
		})
	}else{
		
		try{
			let option = JSON.parse(optionStr)
			chart[funName](option)
		}catch(e){
			chart[funName]()
		}
	}
	
	
	
}