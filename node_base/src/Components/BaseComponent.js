
import React from 'react';
import {Switch,Route} from 'react-router-dom';
import ConsumerDetails from './ConsumerDetails';
import NodeDetails from './NodeDetails';
import Overview from './Overview';
import TopicDetails from './TopicDetails';

const BaseComponents = ()=>{
    return (
        <Switch>
            <Route path="/" component={Overview} exact></Route>
            <Route path="/node" component={NodeDetails} exact></Route>
            <Route path="/topic" component={TopicDetails} exact></Route>
            <Route path="/consumer" component={ConsumerDetails} exact></Route>
        </Switch>
    );
}
export default BaseComponents;