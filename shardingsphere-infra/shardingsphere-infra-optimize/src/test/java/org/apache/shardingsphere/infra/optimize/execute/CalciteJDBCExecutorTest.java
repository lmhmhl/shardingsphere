package org.apache.shardingsphere.infra.optimize.execute;

import org.apache.shardingsphere.infra.metadata.ShardingSphereMetaData;
import org.apache.shardingsphere.infra.metadata.rule.ShardingSphereRuleMetaData;
import org.apache.shardingsphere.infra.optimize.base.AbstractShardingSphereDataSourceForShardingTest;
import org.apache.shardingsphere.infra.optimize.context.CalciteContext;
import org.apache.shardingsphere.infra.optimize.context.CalciteContextFactory;
import org.apache.shardingsphere.infra.optimize.schema.row.CalciteRowExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalciteJDBCExecutorTest extends AbstractShardingSphereDataSourceForShardingTest {

    private CalciteJDBCExecutor calciteJDBCExecutor;

    @BeforeClass
    public static void init() {
    }


    @Before
    public void setUp() throws Exception {
        Map<String, ShardingSphereMetaData> result = new HashMap<>();
        getShardingSphereDataSource().getMetaDataContexts().getAllSchemaNames().forEach(e -> {
            ShardingSphereMetaData metaData = mock(ShardingSphereMetaData.class);
            when(metaData.getRuleMetaData()).thenReturn(new ShardingSphereRuleMetaData(Collections.emptyList(), Collections.emptyList()));
            result.put(e, metaData);
        });
        CalciteContextFactory calciteContextFactory = new CalciteContextFactory(result);

        CalciteContext calciteContext = calciteContextFactory.create("schema", mock(CalciteRowExecutor.class));
        calciteJDBCExecutor = new CalciteJDBCExecutor(calciteContext);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void executeQuery() {

    }

    @Test
    public void close() {
    }
}