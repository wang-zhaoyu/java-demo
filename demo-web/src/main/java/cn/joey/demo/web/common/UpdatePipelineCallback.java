package cn.mobilemart.demo.web.common;

import com.baidu.disconf.client.common.update.IDisconfUpdatePipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UpdatePipelineCallback implements IDisconfUpdatePipeline {
    private static Logger logger           = LoggerFactory.getLogger(UpdatePipelineCallback.class);
    @Override
    public void reloadDisconfFile(String key, String filePath) throws Exception {
        logger.info("reloadDisconfFile  key是："+key + " : " + filePath);
    }

    @Override
    public void reloadDisconfItem(String key, Object content) throws Exception {
        logger.info("reloadDisconfItem  key是："+key + " : " + content);
    }

    
}
