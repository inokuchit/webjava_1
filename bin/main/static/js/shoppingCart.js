$(function() {
  var goods = new Object();

    /*
     * ボタンクリックで処理を開始
     */
       $(document).on('click',".add_goods",function(){
         var data      = $(this).data();          //ボタンに定義されているデータ
         var quantity  = $(data.id).val();        //選択した数量
         var sub_total = data.kakaku * quantity;  //単価 * 数量

       //オブジェクトを定義
         goods[data.number] = new Object();  //同じ商品を初期化
         goods[data.number] = {
            'name':data.name
           ,'kakaku':data.kakaku
           ,'quantity':quantity
           ,'sub_total':sub_total
         };

         cart_open();
       });

    /*
     * カートの中身のHTMLを作る
     */
      var cart_open = function(){
        $("#goods_list").html('');

        var html = '<ul>';
        var key;
        var total = 0;
        for (key in goods){
          html  += '<li>'+goods[key].name+' 個数:'+goods[key].quantity+' &nbsp;&nbsp;'+comma( goods[key].sub_total )+'円</li>';
          total += goods[key].sub_total;
        }
        html += '</ul>';
        html += '<div id="total">合計:'+comma( total )+'円</div>';

        //オブジェクトなのでそのままではPOSTの出来ないためJSON形式にする
        var data = JSON.stringify(goods);

        $("#goods_list").html(html); //上部カートにHTMLを挿入
        $("#cart_detail").show();    //カートを開く
        $("#data").val(data);        //POST[data]にカートの中身をセット

      }

    /*
     * フォームをPOSTする
     */
      $(document).on('click',"#go_cart a",function(){
        document.form.submit();
      });

    /*
     * カートを閉じる
     */
      $(document).on('click',"#close_cart span",function(){
        $("#cart_detail").hide();
      });

});

/*
 * 3桁ごとにカンマ
 */
  function comma(num) {
      return num.toString().replace( /([0-9]+?)(?=(?:[0-9]{3})+$)/g , '$1,' );
  }