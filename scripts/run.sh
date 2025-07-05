#!/bin/bash

export AERON_DIR=/tmp/aeron
java \
--add-opens java.base/sun.nio.ch=ALL-UNNAMED \
-Djava.util.logging.config.file=/Users/apurvasingh/projects/market_maker/scripts/logging.properties \
-Daeron.printConfiguration=true \
-Daeron.driver.debug.timeout=true \
-Daeron.log.buffer.length=134217728 \
-Daeron.term.buffer.sparse.file=true \
-Daeron.event.log=all \
-Daeron.dir=/tmp/aeron \
-cp aeron-all-1.42.1.jar \
io.aeron.driver.MediaDriver
