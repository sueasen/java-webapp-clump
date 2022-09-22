'use strict';

// ページリンクのリスト
const pageLinks = [
  {title:'For/If', path:'./retro_forif', category:'Retrospective'},
  {title:'Method', path:'./retro_method', category:'Retrospective'},
  {title:'Class', path:'./retro_class', category:'Retrospective'},
  {title:'WebAppSample', path:'./web_app_sample', category:'Web Application'},
  {title:'WebAppWork', path:'./web_app_work', category:'Web Application'},
  {title:'More...', path:'#', category:'Comming Soon'},
  {title:'Sample', path:'./sample', category:'Sample'},
];

/**
 * html 読込時の処理
 */
window.addEventListener('load', (e) => {
  pageLinks.forEach((links, i) => {
    applyNavbar(links);
    applyCarousel(links, i);
  });
  document.querySelectorAll('.chapter_img').forEach(dom => apiPerson(dom));
});

/**
 * ナビゲーションにページリンク設定
 * 
 * @param links
 *            ページリンク情報
 */
function applyNavbar(links) {
  if (!document.querySelector('#navbarCollapse')) return;

  let navItem = document.createElement('li');
  navItem.classList.add('nav-item');
  let navLink = document.createElement('a');
  navLink.classList.add('nav-link');
  navLink.innerText = links.title;
  navLink.href = links.path;
  document.querySelector('#navbarCollapse').querySelector('ul').appendChild(navItem);
  navItem.appendChild(navLink);
}

/**
 * カルーセルにページリンク設定
 * 
 * @param links
 *            ページリンク情報
 * @param index
 *            位置情報
 */
function applyCarousel(links, index) {
  if (!document.querySelector('#myCarousel')) return;

  let carouselBtn = document.createElement('button');
  carouselBtn.dataset.bsTarget = '#myCarousel';
  carouselBtn.dataset.bsSlideTo = index;
  if (index == 0) carouselBtn.classList.add('active');
  document.querySelector('#myCarousel').querySelector('.carousel-indicators').appendChild(carouselBtn);

  let carouselItem = document.createElement('div');
  carouselItem.classList.add('carousel-item');
  if (index == 0) carouselItem.classList.add('active');
  let carouselCaption = document.createElement('div');
  carouselCaption.classList.add('carousel-caption');
  let carouselCaptionTitle = document.createElement('h1');
  carouselCaptionTitle.innerText = [links.category, links.title].join(' ');
  let carouselCaptionDescription = document.createElement('p');
  carouselCaptionDescription.innerText = 'Comment to make it look like it. Anything is fine!';
  let carouselCaptionLink = document.createElement('a');
  carouselCaptionLink.classList.add('btn', 'btn-lg', 'btn-primary');
  carouselCaptionLink.innerText = links.title;
  carouselCaptionLink.href = links.path;
  document.querySelector('#myCarousel').querySelector('.carousel-inner').appendChild(carouselItem);
  carouselItem.appendChild(carouselCaption);
  carouselCaption.appendChild(carouselCaptionTitle);
  carouselCaption.appendChild(carouselCaptionDescription);
  carouselCaption.appendChild(carouselCaptionLink);

  if (index % 2 === 1) {
    apiFox(carouselItem);
  } else {
    apiCat(carouselItem);
  }
}

/**
 * api を実行して json を処理します
 * 
 * @param {String}
 *            url リクエストURL
 * @param {function}}
 *            functionJson json に対する処理
 * @param {Array}
 *            params リクエストURL実行時のパラメータ
 * @param {Array}
 *            options リクエストURL実行時のオプション
 */
function apiJson(url, functionJson, params = {}, options = {}) {
    let requestUrl = url;
    if (Object.keys(params).length > 0) {
        requestUrl = url + '?' + new URLSearchParams(params);
    }
    fetch(requestUrl, options)
        .then(response => {
            if (!response.ok) {
                throw new Error(response.status + ':' + response.statusText);
            }
            return response.json();
        })
        .then(json => functionJson(json))
        .catch((error) => {
            console.log(error);
        });
}

/**
 * 人情報取得 api を実行して dom に画像を設定
 * 
 * @param {HTMLElement}
 *            dom 画像設定するDOM
 */
function apiPerson(dom) {
    let url = 'https://randomuser.me/api';
    apiJson(url, (json) => dom.style.backgroundImage = 'url(' + json.results[0].picture.large + ')');
}

/**
 * 狐取得 api を実行して dom に画像を設定
 * 
 * @param {HTMLElement}
 *            dom 画像設定するDOM
 */
function apiFox(dom) {
    let url = 'https://randomfox.ca/floof/';
    apiJson(url, (json) => dom.style.backgroundImage = 'url(' + json.image + ')');
}

/**
 * 猫取得 api を実行して dom に画像を設定
 * 
 * @param {HTMLElement}
 *            dom 画像設定するDOM
 */
function apiCat(dom) {
    let url = 'https://aws.random.cat/meow';
    apiJson(url, (json) => dom.style.backgroundImage = 'url(' + json.file + ')');
}
