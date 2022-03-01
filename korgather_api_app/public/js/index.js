function a() {
	console.log("1");
}

function submit() {
	axios
		.post("https://gather.town/api/getMap", {
			api_key: $("#api_key").val(),
			space_id: $("#map_id").val(),
			map_id: $("#room_name").val(),
		})
		.then(function (response) {
			// response
			console.log(response);
			console.log("굿");
		})
		.catch(function (error) {
			// 오류발생시 실행
		})
		.then(function () {
			// 항상 실행
		});
}

// // async await 함수를 사용할 때,

// try {
// 	const data = await axios.post("https://gather.town/api/getMap");
// } catch {
// 	// 오류 발생시 실행
// }

function handleTabs() {
	var tabNavEls = document.querySelectorAll(".tabs ul > li");
	var tabContentEls = document.querySelectorAll(".tabs-content > div");

	for (i = 0; i < tabNavEls.length; i++) {
		tabNavEls[i].addEventListener("click", function () {
			var target = this.dataset.tab;

			for (nav = 0; nav < tabNavEls.length; nav++) {
				tabNavEls[nav].classList.remove("is-active");
			}

			this.classList.add("is-active");

			for (content = 0; content < tabContentEls.length; content++) {
				tabContentEls[content].setAttribute("style", "display:none");
			}
			var targetContent = document.querySelector(
				'.tabs-content > div[data-tab="' + target + '"]'
			);
			targetContent.setAttribute("style", "display:block");
		});
	}
}

handleTabs();
