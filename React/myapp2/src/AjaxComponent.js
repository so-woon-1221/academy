import React, {useEffect, useState} from 'react';

const AjaxComponent = () => {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    useEffect(() => {
        fetch('http://pjs.dothome.co.kr/ajaxDB2.php')
            .then(res => res.json())
            .then(result => {
                    setIsLoaded(true);
                    setItems(result);
                },
                error => {
                    setIsLoaded(true);
                    setError(error)
                }
            )
    }, []);

    if (error) {
        return <div>Error: {error.message}</div>
    } else if (!isLoaded) {
        return <div>Loading...</div>
    } else {
        return (
            <ul>
                {items.map(item => (<li key={item.id}>{item.name} {item.price}</li>))}
            </ul>
        );
    }
};

export default AjaxComponent;
