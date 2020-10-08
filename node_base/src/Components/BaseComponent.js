
import React from 'react';

import {Switch,Route} from 'react-router-dom';
import ConsumerDetails from './ConsumerDetails';
import NodeContainer from './ClusterNode/NodeContainer';
import Overview from './Overview';
import TopicsContainer from './Topics/TopicsContainer';

const BaseComponents = ()=>{
    return (        
        <Switch>
            <Route path="/" component={Overview} exact></Route>
            <Route path="/node" component={NodeContainer} exact></Route>
            <Route path="/topic" component={TopicsContainer} exact></Route>
            <Route path="/consumer" component={ConsumerDetails} exact></Route>
        </Switch>
    );
}
export default BaseComponents;