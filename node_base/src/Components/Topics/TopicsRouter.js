
import React from 'react';

import {Switch,Route} from 'react-router-dom';
import TopicsContainer from './TopicsContainer';
import PartitionContainer from './PartitionContainer';

const TopicRouter = ()=>{
    return (        
        <Switch>
            <Route path="/topic" component={TopicsContainer} exact></Route>
            <Route path="/topic/:topicName/partition" component={PartitionContainer} exact></Route>
        </Switch>
    );
}
export default TopicRouter;