import React, {useCallback, useRef, useState} from 'react';

const Student = () => {
    const nextId = useRef(1);
    const idField = useRef(null);
    const [form, setForm] = useState({id: '', name: '', address: ''});
    const [data, setData] = useState({array: []});

    const onChange = useCallback(e => {
        const {name, value} = e.target;
        setForm({
            ...form,
            [name]: [value]
        })
    }, [form])

    const onSubmit = useCallback(e => {
        e.preventDefault();
        const info = {
            _id: nextId.current,
            name: form.name,
            id: form.id,
            address: form.address,
        }

        setData({
            ...data,
            array: data.array.concat(info)
        })

        setForm({
            id: '',
            name: '',
            address: ''
        })

        nextId.current += 1;
        idField.current.focus();
    }, [data, form.name, form.id, form.address])

    return (
        <div>
            <form onSubmit={onSubmit}>
                <input type={'text'} name={'id'} value={form.id} onChange={onChange} placeholder={'id'} ref={idField}/>
                <input type={'text'} name={'name'} value={form.name} onChange={onChange} placeholder={'name'}/>
                <input type={'text'} name={'address'} value={form.address} onChange={onChange} placeholder={'address'}/>
                <button type={"submit"}>등록</button>
            </form>
            <div>
                <ul>
                    {data.array.map(info => <li key={info._id}>{info.id} {info.name} {info.address}</li>)}
                </ul>
            </div>
        </div>
    )
};

export default Student;
