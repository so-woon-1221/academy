import React, {useCallback, useState} from 'react';

const Exercise4 = () => {
    const [id, setId] = useState('');
    const [data, setData] = useState({});

    const onChange = (e) => {
        setId(e.target.value);
    }

    const getData = useCallback(() => {
        fetch(`http://pjs.dothome.co.kr/ajaxDB3.php?id=${id}`)
            .then(response => response.json())
            // .then(result => console.log(result))
            .then(result => setData(result))
            .catch(e => alert(`오류 발생 : ${e}`));
    }, [id])

    return (
        <div>
            <input value={id} onChange={onChange} placeholder={'id를 입력하세요'}/>
            <button onClick={getData}>찾기</button>
            <ul>
                {data.id && <li>id는 {data.id}</li>}
                {data.name && <li>name은 {data.name}</li>}
                {data.address && <li>address는 {data.address}</li>}
            </ul>
        </div>
    );
};

export default Exercise4;
