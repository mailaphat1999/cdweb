$.widget("ui.autocomplete", $.ui.autocomplete, {
    _renderMenu: function(ul, items) {
        let that = this;
        ul.attr("class", "nav nav-pills nav-stacked  bs-autocomplete-menu");
        $.each(items, function(index, item) {
            that._renderItemData(ul, item);
        });
    },

    _resizeMenu: function() {
        let ul = this.menu.element;
        ul.outerWidth(Math.min(
            ul.width("").outerWidth() + 1,
            this.element.outerWidth()
        ));
    }

});

function autoSearch() {
    let q = $("#search").val();
    let searchItem = null;
    $.ajax({
        type : "post",
        url : "/autosearch",
        data: {q:q},
        dataType: "json",
        success : function(data) {
            searchItem = data;
            showSearch();
        },
        error : function() {
            console.log('Error while request..');
        }
    });

    function showSearch(){
        $('#search').autocomplete({
            minLength: 2,
            source: function (request, response) {
                response($.map(searchItem, function (obj, key) {

                    let name = obj.name.toUpperCase();

                    if (name.indexOf(request.term.toUpperCase()) != -1) {
                        return {
                            label: obj.name, // Label for Display
                            value: obj.id // Value
                        }
                    } else {
                        return null;
                    }
                }));
            },
            focus: function(event, ui) {
                event.preventDefault();
            },
            // Once a value in the drop down list is selected, do the following:
            select: function(event, ui) {
                event.preventDefault();
                // $('#search').val(ui.item.label);
                window.location.href = "/product/detail?id=" +ui.item.value;
            }
        });
    }


}