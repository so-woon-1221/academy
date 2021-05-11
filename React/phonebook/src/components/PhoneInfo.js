// file: src/components/PhoneInfo.js
import React, { Component } from 'react';

class PhoneInfo extends Component {
    static defaultProps = {
        info: {
            name: '이름',
            phone: '010-0000-0000',
            id: 0
        }
    }

    shouldComponentUpdate(nextProps, nextState, nextContext) {
        if (!this.state.editing && !nextState.editing && nextProps.info === this.props.info) {
            return false;
        }
        return true;
    }

    render() {
        const style = {
            border: '1px solid black',
            padding: '8px',
            margin: '8px'
        };

        const {
            name, phone, id
        } = this.props.info;

        return (
            <div style={style}>
                <div><b>{name}</b></div>
                <div>{phone}</div>
            </div>
        );
    }
}

export default PhoneInfo;