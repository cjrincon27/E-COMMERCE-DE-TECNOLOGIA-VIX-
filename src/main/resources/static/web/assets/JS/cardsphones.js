$(function(){
  $('.card').hover(
    function() {
    after = $(this).find('.after'),
    tri = $(this).find('.tri'),
    title = $(this).find('.title'),
    subtitle = $(this).find('.subtitle'),
    span = $(this).find('.category span'),
    spanLength = span.length,
    description = $(this).find('.description'),
    share = $(this).find('.card__footer .share'),
    nbshare = $(this).find('.card__footer .nb-share'),
    site = $(this).find('.card__footer .site'),

    tri.velocity({
      borderTopWidth: 100,
      borderLeftWidth: 200,
    }, {
      duration: 10,
      complete: function() {
      after.velocity({
        translateX: '50%'
      }, {
        duration: 10
      });
      }
    });

    title.velocity({
      opacity: 0
    }).velocity({
      translateY: -100
    }, {
      duration: 100
    }).velocity({
      translateY: '-=15',
      opacity: 1
    }, {
      duration: 130,
      easing: 'ease-out'
    });

    subtitle.velocity({
      opacity: 0
    });

    var i = 0;
    span.each(function() {
      $(this).velocity({
      translateY: -115
      }, {
      duration: 500,
      delay: i * 150
      });
      i++;
    });

    description.velocity({
      translateY: -50,
      opacity: 1
    }, {
      duration: 350,
      delay: 150
    });

    share.velocity({
      opacity: 1,
      left: 0
    }, {
      duration: 450,
      delay: 80,
      easing: 'ease-out'
    });

    nbshare.velocity({
      opacity: 1,
      left: 90
    }, {
      duration: 10,
      delay: 10,
      easing: 'ease-out'
    });

    site.velocity({
      opacity: 1,
      right: 0
    }, {
      duration: 10,
      delay: 10,
      easing: 'ease-out'
    });

  },


  function() {
    after.velocity("reverse");
    tri.velocity("reverse", {
      delay: 200
    });
    title.velocity("reverse").velocity({
      translateY: -20
    }, {
      duration: 110
    }).velocity({
      translateY: 0,
      opacity: 1
    }, {
      duration: 150,
      easing: 'ease-out'
    });
    subtitle.velocity("reverse", {
      delay: 200
    });
    var i = spanLength;
    span.each(function() {
      $(this).velocity("reverse", {
      delay: i * 10,
      duration: 260
      });
      i--;
    });
    description.velocity("reverse");
    share.velocity("reverse", {
      delay: 150,
      easing: 'ease-in'
    });
    nbshare.velocity("reverse", {
      delay: 50,
      easing: 'ease-in'
    });
    site.velocity("reverse", {
      delay: 80,
      easing: 'ease-in'
    });
    }  
    );
});
