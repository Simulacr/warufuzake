var ledgers = [];
var objects = [];

$(document).ready(function(){
    $(window).resize(function () {
        waitForFinalEvent(resizeLedgers, 300, "ledgerResize");
        waitForFinalEvent(resizeObject, 300, "resizeObject");
    });
});

function addLedgerToResize(id){
    ledgers.push(id);
    resizeLedgers();
}

function addObjectToResize(id){
    objects.push(id);
    resizeObject();
}

function resizeLedgers(){
    for(var i=0; i<ledgers.length; i++)
        $("#contentForm\\:" + ledgers[i]).find(".ui-datatable-scrollable-body").css("height", $("#contentForm").parent().height() - 60);
}

function resizeObject() {
    for(var i=0; i<objects.length; i++)
        $("#" + objects[i]).height($("#contentForm").parent().height() - 30);
}

var waitForFinalEvent = (function () {
    var timers = {};
    return function (callback, ms, uniqueId) {
        if (!uniqueId) {
            uniqueId = "Don't call this twice without a uniqueId";
        }
        if (timers[uniqueId]) {
            clearTimeout (timers[uniqueId]);
        }
        timers[uniqueId] = setTimeout(callback, ms);
    };
})();

function checkTestVariant(elem) {
    var classes = elem.className;
    if(classes.indexOf("ui-state-disabled") != -1)
        return;
    if(classes.indexOf("listUnit ui-state-active") == -1)
        elem.className = classes + " listUnit ui-state-active";
    else
        elem.className = classes.replace(" listUnit ui-state-active", "");
}