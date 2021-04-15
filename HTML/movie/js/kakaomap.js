$(window).load(function () {
    let infowindow = new kakao.maps.InfoWindow({zIndex: 1});
    let mapContainer = document.getElementById('map'),
        mapOption = {
            center: new kakao.maps.LatLng(37.534453, 126.898561),
            level: 3
        };

    let map = new kakao.maps.Map(mapContainer, mapOption);

    let markerImage = new kakao.maps.MarkerImage(
        'img/icon/map_marker.svg', new kakao.maps.Size(31, 35), new kakao.maps.Point(13, 34));
    let locPosition = new kakao.maps.LatLng(37.534453, 126.898561);
    let defaultMarker = new kakao.maps.Marker({
        map: map,
        position: locPosition
    })
    defaultMarker.setImage(markerImage);

    function getHere() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition((position) => {
                defaultMarker.setVisible(false);
                let lat = position.coords.latitude;
                let lon = position.coords.longitude;

                locPosition = new kakao.maps.LatLng(lat, lon);
                message = '<div style="padding: 5px">여기에 계신가요?!</div>';

                displayMarker(locPosition, message);

            })
        }
    }

    here.addEventListener('click', () => {
        getHere()
    });

    function displayMarker(locPosition, message) {
        let marker = new kakao.maps.Marker({
            map: map,
            position: locPosition
        });

        marker.setImage(markerImage);

        let iwContent = message,
            iwRemoveable = true;

        let infoWindow = new kakao.maps.InfoWindow({
            content: iwContent,
            removable: iwRemoveable
        });

        infoWindow.open(map, marker);

        map.setCenter(locPosition);
    }

    searchButton.addEventListener('click', () => {
        removeMarker();
        placeSearch()
    });

    function placeSearch() {
        var ps = new kakao.maps.services.Places();

// 키워드로 장소를 검색합니다
        ps.keywordSearch('영화관', placesSearchCB, {
            sort: kakao.maps.services.SortBy.distance,
            location: map.getCenter(),
            // radius: locPosition,
            useMapCenter: true,
            size: 15,
        });
    }

//     var ps = new kakao.maps.services.Places();
//
// // 키워드로 장소를 검색합니다
//     ps.keywordSearch('영화관', placesSearchCB, {
//         sort: kakao.maps.services.SortBy.distance,
//         location: locPosition,
//         // radius: locPosition,
//         useMapCenter: true,
//         size: 15,
//     });

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
    function placesSearchCB(data, status, pagination) {
        if (status === kakao.maps.services.Status.OK) {

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
            // LatLngBounds 객체에 좌표를 추가합니다
            var bounds = new kakao.maps.LatLngBounds();

            for (var i = 0; i < data.length; i++) {
                displayMarker2(data[i]);
                bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
            }

            // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
            map.setBounds(bounds);
        }
    }

    let markers = [];

// 지도에 마커를 표시하는 함수입니다
    function displayMarker2(place) {

        // 마커를 생성하고 지도에 표시합니다
        let marker = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(place.y, place.x),
            level: 3
        });

        markers.push(marker);

        let div = document.createElement('div');
        div.style.borderBottom = '1px solid gray';
        div.classList.add('now');
        let name = place.place_name;
        let address = place.road_address_name;
        let distance = place.distance;
        let nameE = document.createElement('h4');
        nameE.innerHTML = name;
        let addressE = document.createElement('p');
        addressE.innerText = address + '  /  ' + distance + 'm';
        div.append(nameE);
        div.append(addressE);
        div.addEventListener('click', () => {
            infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
            infowindow.open(map, marker);
            window.scrollTo({top: 0, behavior: 'smooth'});
            map.setCenter(new kakao.maps.LatLng(place.y, place.x));
            map.setLevel(6);
        })
        content.insertAdjacentElement('beforeend', div);

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, 'click', function () {
            // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
            infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
            infowindow.open(map, marker);
            map.setCenter(new kakao.maps.LatLng(place.y, place.x));
            if (map.getLevel() < 5) {
                map.setLevel(5)
            }
        });
    }

    function removeMarker() {
        let elems = content.querySelectorAll('.now')
        for (let elem of elems) {
            elem.remove();
        }
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(null);
        }
        markers = [];
    }
})
