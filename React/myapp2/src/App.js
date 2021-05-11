import React from 'react';
import EventPractice from "./EventPractice";
import MyComponent from "./MyComponent";
import AjaxComponent from "./AjaxComponent";

const App = () => {
    return (
        <div>
            <EventPractice/>
            <MyComponent name={'gg'}/>
            <AjaxComponent/>
        </div>
    );
};

export default App;
